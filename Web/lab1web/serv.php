	<?php
		

		if (!isset($_COOKIE['data'])) {
		    setcookie('data', '<tr></tr>', time() + 3600 * 24 * 365 * 50, '/');
		    setcookie('id', 0, time() + 3600 * 24 * 365 * 50, '/');
		}
		
		function check($x, $y, $r){
			if($x >= 0 && $x <= $r && $y <= 0 && $y >= -$r){
				return "Попал";
			}

			else if($x <= 0 && $x >= -$r && $y <= 0 && $y >= -($r / 2)){
				if(-$x - 2 * $y <= $r){ 
					return "Попал";
				}
			}
			else if($x >= 0 && $y >= 0) {
				if($x * $x + $y * $y <= $r * $r) {
					return "Попал";
				}
			}

			return "Не попал";
		}

		function get_data(){
			return $_COOKIE["data"];
		}

		function set_data(){
			$time_start = microtime(true);
			$timezone = new DateTimeZone('Europe/Moscow');
			$date = new DateTime('now', $timezone);

			$x = $_POST["x"];
			$y = $_POST["y"];
			$r = $_POST["r"];
			$res = '';
			foreach ($r as $val) {
				$res .= '
				<tr class="data">
			    	<td>'. ++$_COOKIE["id"] .'</td>
			    	<td>'. $x .'</td>
			    	<td>'. $y .'</td>
			    	<td>'. $val .'</td>
			    	<td>'. check($x, $y, $val) .'</td>
			    	<td>'. $date->format('Y-m-d H:i:s') .'</td>
			    	<td>'. (microtime(true) - $time_start) * 1000 .'</td>
			  	</tr>';
			  	setcookie('id', $_COOKIE["id"], time() + 3600 * 24 * 365 * 50, '/');
			}

			setcookie('data', $_COOKIE["data"] . $res, time() + 3600 * 24 * 365 * 50, '/');
			return $res;
		}

		function reset_data(){
			setcookie('data', '<tr></tr>', time() + 3600 * 24 * 365 * 50, '/');
			setcookie('id', 0, time() + 3600 * 24 * 365 * 50, '/');
		}

		$req = $_POST["req"];

		if($req == "get_data") echo json_encode(get_data());
		else if($req == "set_data") echo json_encode(set_data());
		else if($req == "reset_data") reset_data();
	?>