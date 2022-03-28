<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<title>QUIZZ</title>
</head>
<body>
	
	<jsp:include page="menu.jsp"></jsp:include>
	
	<div class="container-fluid">
		<form action="<%=request.getContextPath()%>/ServletQuizz" id="formUser" method="post">
			<div class="container-fluid border border-3 border-dark rounded bg-dark p-3 mb-2 text-light">
				<div class="mb-3">
				  <label for="tituloPergunta" class="form-label fw-bold">Título: </label>
				  <input type="text" class="form-control" id="tituloPergunta" name="tituloPergunta">
				</div>
				<div class="mb-3">
				  <label for="textoPergunta" class="form-label fw-bold">Escreva Mensagem: </label>
				  <textarea class="form-control" id="textoPergunta" name="textoPergunta" rows="3" placeholder="Como fazer..."></textarea>
				</div>
				<button class="btn btn-success" type="submit" onclick="buscarUsuario();">CRIAR PERGUNTA/RESPOSTA</button>
			</div>
		</form>
		
		
		<div class="row row-cols-1 row-cols-md-3 g-4" id="resultadoQuizz">
		  <div class="col-4">
		    <div class="card h-100 text-white bg-success">
		    	<h5 class="card-header">Como escrever CSS?</h5>
		      <div class="card-body">
		        <p class="card-text">This is a longernt is a little bit longer.</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-4">
		    <div class="card h-100 text-white bg-success">
		    	<h5 class="card-header">Como escrever CSS?</h5>
		      <div class="card-body">
		        <p class="card-text">This is a longernt is a little bit longer.</p>
		      </div>
		    </div>
		  </div>
		  <div class="col-4">
		    <div class="card h-100 text-white bg-success">
		    	<h5 class="card-header">Como escrever CSS?</h5>
		      <div class="card-body">
		        <p class="card-text">This is a longernt is a little bit longer.</p>
		      </div>
		    </div>
		  </div>
		</div>
		
	</div>
	
	
	
	
	<script type="text/javascript">
		var urlAction = document.getElementById('formUser').action;
		function buscarUsuario() {
			
			$.ajax({
				method: "get",
				url: urlAction,
				data: "acao=buscarQuizz",
				success: function(response) {
					alert(response);
					var json = JSON.parse(response);
					alert(json);
					alert("foi2")
					
					$('#resultadoQuizz > card').remove();
					
					for(var p = 0; p<json.length; p++) {
						$('#resultadoQuizz').append('foi');
					}
				}
			}).fail(function(xhr, status, errorThrown) {
				alert('Erro ao buscar usuário por id: ' + xhr.responseText);
			});
		}
		
	
	</script>
	
	
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
</body>
</html>