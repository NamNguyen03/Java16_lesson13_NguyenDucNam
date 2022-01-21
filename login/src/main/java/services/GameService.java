package services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import models.GameRecord;
import models.User;

public class GameService {
	private static GameService instance = null;
	private List<GameRecord> gameRecords;
	
	
	private GameService() {
		gameRecords  = new ArrayList<>();
	}
	
	public static GameService init() {
		if(instance == null) {
			instance = new GameService();
		}
		return instance;
	}

	public GameRecord findGameRecordNoFinnishByUser(User user) {
		
		Optional<GameRecord> gameRecordOpt = gameRecords.stream().filter(i -> i.getUser().getEmail().equals(user.getEmail()) && !i.isFinished()).findFirst(); 
		
		if(gameRecordOpt.isEmpty()) {
			GameRecord gameRecord = new GameRecord(user);
			gameRecords.add(gameRecord);
			
			return gameRecord;
		}
		
		return gameRecordOpt.get();
	}

	public GameRecord setNumberCurrentWithUser(int inputNumber, User user) {
		GameRecord gameRecord = gameRecords.stream().filter(i -> i.getUser().getEmail().equals(user.getEmail()) && !i.isFinished()).findFirst().get(); 

		gameRecord.setPoint(gameRecord.getPoint() +1);
		
		gameRecord.setNumberCurrent(inputNumber);
		
		if(inputNumber == gameRecord.getNumberTarget()) {
			gameRecord.setFinishDate(LocalDateTime.now());
			gameRecord.setFinished(true); 
			return gameRecord;
		}
		
		return gameRecord;
	}

	public List<GameRecord> getRank() {
		return gameRecords.stream().filter(i -> i.isFinished())
					.sorted((i, i2) -> i.getPoint() - i2.getPoint()).collect(Collectors.toList());
	}
	
	
}
