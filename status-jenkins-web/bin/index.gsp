<!doctype html>
<html lang="en" class="no-js">
	<head>
	    <title>Status Jenkins</title>
	    <meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1">
	    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
	    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    <script src="form.js"></script>
	</head>
    <body>
	<form class="form-horizontal">
		 <fieldset>
		
		 <!-- Form Name -->
		 <legend>Verificar status do projeto no Jenkins</legend>
		
		 <!-- Text input-->
		 <div class="form-group">
		     <label class="col-md-4 control-label" for="textinput">Url*</label>  
		     <div class="col-md-6">
		     <input id="textinput" name="textinput" type="text" placeholder="Ex: ./Projeto1/api/json" class="form-control input-md" required="">
		     <span class="help-block">Url do projeto à ser observado no jenkins</span>  
		     </div>
		 </div>
		
		 <!-- Text input-->
		 <div class="form-group">
		   <label class="col-md-4 control-label" for="textinputSerial">Porta serial*</label>  
		   <div class="col-md-2">
		   <input id="textinputSerial" name="textinputSerial" type="text" placeholder="" class="form-control input-md" required="">
		   <span class="help-block">Dispositivo conectado</span>  
		   </div>
		 </div>
		
		 <!-- Button (Double) -->
		    <div class="form-group">
		        <label class="col-md-4 control-label" for="button1id"></label>
		        <div class="col-md-8">
		            <button id="iniciar" name="button1id" class="btn btn-success">Iniciar</button>
		            <button id="cancelar" name="button2id" class="btn btn-danger">Cancelar</button>
		        </div>
		    </div>
		
		    </fieldset>
		</form>
    </body>
</html>