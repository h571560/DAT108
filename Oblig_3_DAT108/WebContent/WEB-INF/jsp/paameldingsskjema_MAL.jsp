<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Fra https://purecss.io/ -->
<link rel="stylesheet"
	href="https://unpkg.com/purecss@1.0.0/build/pure-min.css">
<title>P�melding</title>
</head>
<body>
	<h2>P�melding</h2>
	<form method="post" class="pure-form pure-form-aligned">
		<fieldset>
			<div class="pure-control-group">
				<label for="fornavn">Fornavn:</label> <input id="inputFornavn" type="text"
					name="fornavn" value="${skjema.fornavn}"/> <font color="red" id="feilFornavn">${skjema.fornavnFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="etternavn">Etternavn:</label> <input id="inputEtternavn" type="text"
					name="etternavn" value="${skjema.etternavn}" /> <font color="red" id="feilEtternavn">${skjema.etternavnFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="mobil">Mobil (8 siffer):</label> <input id="inputMobil" type="text"
					name="mobil" value="${skjema.mobil}" /> <font color="red" id="feilMobil">${skjema.mobilFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="password">Passord:</label> <input id="inputPassord" type="password"
					name="passord" value="${skjema.passord}"/>
					<font id="feilPassord" color="red">${skjema.passordFeilmelding}</font>
					<font id="middlePassord" color="orange"></font>
					<font id="strongPassord" color="green"></font>
			</div>
			<div class="pure-control-group">
				<label for="passordRepetert">Passord repetert:</label> <input id="inputPassordRepetert"
					type="password" name="passordRepetert" value="${skjema.passordRep}"/> <font id="feilPassordRepetert"
					color="red">${skjema.passordRepFeilmelding}</font>
			</div>
			<div class="pure-control-group">
				<label for="kjonn">Kj�nn:</label> <input  type="radio" onchange="validerKjonn()" name="kjonn"
					value="mann" ${skjema.mannC} />mann <input type="radio" onchange="validerKjonn()" name="kjonn"
					value="kvinne" ${skjema.kvinneC}/>kvinne <font id="feilKjonn" color="red">${skjema.kjonnFeilmelding}</font>
			</div>
			<div class="pure-controls">
				<button type="submit" class="pure-button pure-button-primary">Meld
					meg p�</button>
			</div>
		</fieldset>
	</form>
	<script type="text/javascript" charset="ISO-8859-1" src="${pageContext.request.contextPath}/validation.js" defer></script>
</body>
</html>