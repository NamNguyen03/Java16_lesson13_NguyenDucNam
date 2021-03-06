<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="utils.UrlConst"%>
<!doctype html>
<html lang="en">
  <head>
    <title>Game play</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  <body>
    <div style="width:30%; margin-inline: auto; min-width: 300px; display: flex; flex-direction: column; text-align: center;">
		<h1 style="text-align: center;" >Play</h1>
    <p>Number ${suggest} ${gameRecord.numberCurrent}</p>
    <p>Point : ${gameRecord.point}</p>
    <form class="w-100" action="<%=request.getContextPath() + UrlConst.GAME_PLAY %>" method="post">
      <div class="form-group mx-sm-3 mb-2">
        <div class="form-group mx-sm-3 mb-2">
          <input type="number" name="number" class="form-control" id="number" placeholder="number">
        </div>
        <button type="submit" class="btn btn-primary mb-2">submit</button>
      </div>
    </form>
    </div>
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>