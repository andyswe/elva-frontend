<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Elva</title>
    <link type="text/css" href="/css/bootstrap.css" rel="stylesheet" />
    <link type="text/css" rel="stylesheet" src="/css/dygraph.css" />

    <script type="application/javascript" src="/js/jquery.js"></script>
        <script type="application/javascript" src="/js/bootstrap.js"></script>
        <script type="application/javascript" src="/js/dygraph.js"></script>
        <script type="application/javascript" src="/js/dygraph.min.js"></script>

          <style type="text/css">
            #div_g {
              position: absolute;
              left: 10px;
              right: 10px;
              top: 40px;
              bottom: 10px;
            }
            </style>

</head>
<body>

    

    <div id="div_g"></div>
<script type="text/javascript">
  g2 = new Dygraph(
    document.getElementById("div_g"),
    "data/somestring",
    { }          // options
  );
</script>

    


</body>
</html>