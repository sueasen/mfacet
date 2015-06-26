<!DOCTYPE html>
<html lang="ja">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>TODC Bootstrap 101 Template</title>

    <!-- Bootstrap -->
    <link href="<c:url value='/static/css/bootstrap.min.css' />" rel="stylesheet"></link>
    <!-- TODC Bootstrap theme -->
    <link href="<c:url value='/static/css/todc-bootstrap.min.css' />" rel="stylesheet"></link>
    <!-- Custom styles for this template -->
    <link href="<c:url value='/static/css/signin.min.css' />" rel="stylesheet"></link>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
  <body>
    <h1>Hello, world!</h1>
    <input type="text"></input>

<button type="button" class="btn btn-default">Default</button>
<button type="button" class="btn btn-primary">Primary</button>
<button type="button" class="btn btn-success">Success</button>
<button type="button" class="btn btn-info">Info</button>
<button type="button" class="btn btn-warning">Warning</button>
<button type="button" class="btn btn-danger">Danger</button>
<button type="button" class="btn btn-link">Link</button>

                <button type="button" class="btn btn-primary btn-lg">Large button</button>
                <button type="button" class="btn btn-default btn-lg">Large button</button>

<hr>
    <div class="container">

      <h2 class="form-signin-heading text-center">Sign in with your Account</h2>

      <div class="card card-signin">
        <img class="img-circle profile-img" src="img/avatar.png" alt="">
        <form class="form-signin">
          <label for="inputUserId" class="sr-only">User ID</label>
          <input type="text" id="userId" class="form-control" placeholder="User ID" required autofocus>
          <label for="inputPassword" class="sr-only">Password</label>
          <input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
          <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

        </form>
      </div>

      <p class="text-center">
        <a>Create an account</a>
      </p>

    </div> <!-- /container -->


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>