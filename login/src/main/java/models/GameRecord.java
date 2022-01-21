package models;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class GameRecord {
	private int id;
	private User user;
	private int numberTarget;
	private int numberCurrent;
	private int point;
	private LocalDateTime finishDate;
	private boolean isFinished;
	
	private static int idNext = 1;
	
	public GameRecord(User user) {
		id = idNext++;
		isFinished = false;
		point = 0;
		numberCurrent = 0;
		this.user = user;
		numberTarget = (int) (Math.random() * 1000) + 1;
	}
	
}
