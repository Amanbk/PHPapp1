<?php

$firstname= $_POST["firstname"];
$lastname= $_POST["lastname"];

if ((!empty(firstname))&& (&empty(lastname))){
  echo $firstname;
}else{
  echo "please fill out the forms";
}



?>
