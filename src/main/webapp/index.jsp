<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<title>Login QUIZZ</title>
</head>
<body class="bg-dark ">



		<div class="position-absolute top-50 start-50 translate-middle">
		<div class="p-2  bg-body rounded">
			<h3 >Login</h3>
			<form action="<%= request.getContextPath()%>/ServletLogin" method="post" class="needs-validation" novalidate>
			  <div class="mb-3">
			    <label for="email" class="form-label">E-mail</label>
			    <input type="email" class="form-control" id="email" name="email" required>
			    <div id="ajudaEmail" class="form-text">Nós nunca compartilhamos seu e-mail com ninguém.</div>
			    <div class="valid-feedback">
			      OK!
			    </div>
			    <div class="invalid-feedback">
			        Por favor, coloque um e-mail valido.
			    </div>
			  </div>
			  <div class="mb-3">
			    <label for="senha" class="form-label">Senha</label>
			    <input type="password" class="form-control" id="senha">
			    <div class="invalid-feedback">
			        Por favor, coloque uma senha válida!
			    </div>
			  </div>
			  <button type="submit" class="btn btn-success">ENTRAR</button>
			  <button type="submit" class="btn btn-primary">REGISTRAR</button>
			</form>
		</div>
		</div>


	
	
	 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

	<script type="text/javascript">
	(function () {
		  
		  var forms = document.querySelectorAll('.needs-validation')

		  // Loop over them and prevent submission
		  Array.prototype.slice.call(forms)
		    .forEach(function (form) {
		      form.addEventListener('submit', function (event) {
		        if (!form.checkValidity()) {
		          event.preventDefault()
		          event.stopPropagation()
		        }

		        form.classList.add('was-validated')
		      }, false)
		    })
		})()
	
	
	</script>
</body>
</html>