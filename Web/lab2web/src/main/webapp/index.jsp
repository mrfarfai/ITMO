<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.daos.PointDao" %>
<%@ page import="com.example.models.Point" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="stylesheets/styles.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <script type="text/javascript">
        function drawPoint(x, y, r, result) {
            let circle = document.createElementNS("http://www.w3.org/2000/svg", "circle");
            circle.setAttribute("cx", x * 60 * 2 / r + 150);
            circle.setAttribute("cy", -y * 60 * 2 / r + 150);
            circle.setAttribute("r", 3);
            circle.style.fill = result ? "#09a53d" : "#a50909";
            $("svg").append(circle);
        }
    </script>
    <title>Lab 2 Web</title>
</head>
<body>
<nav>
    <img src="https://itmo.ru/promo/itmo-logo-dark.svg">
    <p class="variant">В-2247</p>
    <p class="author">Файзиев Фаридун - P3212</p>
</nav>

<content>
    <main>
        <div id = "bodyA">
            <div id="graff">
                <svg height="300" width="300" xmlns="http://www.w3.org/2000/svg">
                    <!--                Оси-->
                    <line stroke="black" x1="150" x2="150" y1="300" y2="0"></line>
                    <text x="160" y="12">Y</text>
                    <line stroke="black" x1="0" x2="300" y1="150" y2="150"></line>
                    <text x="286" y="135">X</text>
                    <!--                Промежутки-->
                    <line stroke="black" x1="147" x2="153" y1="30" y2="30"></line>
                    <text x="160" y="35">R</text>
                    <line stroke="black" x1="147" x2="153" y1="90" y2="90"></line>
                    <text x="160" y="95">R/2</text>
                    <line stroke="black" x1="147" x2="153" y1="210" y2="210"></line>
                    <text x="160" y="215">-R/2</text>
                    <line stroke="black" x1="147" x2="153" y1="270" y2="270"></line>
                    <text x="160" y="275">-R</text>
                    <line stroke="black" x1="30" x2="30" y1="147" y2="153"></line>
                    <text x="23" y="140">-R</text>
                    <line stroke="black" x1="90" x2="90" y1="147" y2="153"></line>
                    <text x="83" y="140">-R/2</text>
                    <line stroke="black" x1="210" x2="210" y1="147" y2="153"></line>
                    <text x="202" y="140">R/2</text>
                    <line stroke="black" x1="270" x2="270" y1="147" y2="153"></line>
                    <text x="264" y="140">R</text>
                    <!--                Стрелочки-->
                    <line stroke="black" x1="300" x2="290" y1="150" y2="146"></line>
                    <line stroke="black" x1="300" x2="290" y1="150" y2="154"></line>
                    <line stroke="black" x1="150" x2="146" y1="0" y2="10"></line>
                    <line stroke="black" x1="150" x2="154" y1="0" y2="10"></line>

                    <!--                Выделенная область-->


                    <rect x="90" y="150" width="60" height="120" fill-opacity="0.4" stroke="navy" fill="#00b8ff"></rect>

                    <polygon points="150,150 90,150 150,90" fill-opacity="0.4" stroke="navy" fill="#00b8ff"></polygon>

                    <path d="M150 150 L 270 150 C 270 80 220 30 150 30 L Z" fill-opacity="0.4" stroke="navy" fill="#00b8ff"></path>

                </svg>
            </div>
            <form>
                <div class="form-div">
                    <label class="form-label">Значение X:</label>
                    <input type="button" name="x" value="-2">
                    <input type="button" name="x" value="-1.5">
                    <input type="button" name="x" value="-1">
                    <input type="button" name="x" value="-0.5">
                    <input type="button" name="x" value="0">
                    <input type="button" name="x" value="0.5">
                    <input type="button" name="x" value="1">
                    <input type="button" name="x" value="1.5">
                    <input type="button" name="x" value="2">
                </div>

                <div class="form-div">
                    <label class="form-label">Значение Y:</label>
                    <input type="text" name="y" placeholder="-5 ... 5">
                </div>

                <div class="form-div" style="margin-bottom: 20px;">
                    <label class="form-label">Значение R:</label>
                    <div class="form-r-div">
                        <div class="checkbox-div">
                            <input type="radio" name="r" id="1" value="1">
                            <label for="1">1</label>
                        </div>
                        <div class="checkbox-div">
                            <input type="radio" name="r" id="1.5" value="1.5">
                            <label for="1.5">1.5</label>
                        </div>
                        <div class="checkbox-div">
                            <input type="radio" name="r" id="2" value="2">
                            <label for="2">2</label>
                        </div>
                        <div class="checkbox-div">
                            <input type="radio" name="r" id="2.5" value="2.5">
                            <label for="2.5">2.5</label>
                        </div>
                        <div class="checkbox-div">
                            <input type="radio" name="r" id="3" value="3">
                            <label for="3">3</label>
                        </div>
                    </div>
                </div>

                <span class="check">Проверить</span>

            </form>
    </main>
    <section style="width: 40%">
        <table>
            <tr>
                <th>X</th>
                <th>Y</th>
                <th>R</th>
                <th>Факт</th>
            </tr>
            <% PointDao dao = (PointDao) request.getSession().getAttribute("bean");
                if (dao != null) {
            %>
            <% for (Point point : dao.getPoints()) { %>
            <tr>
                <td>
                    <%= point.getX() %>
                </td>
                <td>
                    <%= point.getY() %>
                </td>
                <td>
                    <%= point.getR() %>
                </td>
                <td>
                    <%= point.isInArea() ? "Попал" : "Промазал" %>
                </td>

                <script type="text/javascript">
                    drawPoint(<%= point.getX() %>, <%= point.getY() %>, <%= point.getR() %>, <%= point.isInArea()%>);
                </script>
            </tr>
            <%
                    }
                }
            %>
        </table>
    </section>

</content>
<script type="text/javascript" src="script.js"></script>
</body>
</html>