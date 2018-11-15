let etternavnReg = /^[A-ZÆØÅ][a-zæøåA-ZÆØÅ,.'-]+$/u;
let fornavnReg = /^[A-ZÆØÅ][a-zæøåA-ZÆØÅ,.'-]+$/u;
let mobilReg = /^[0-9]{8,8}$/;
let passordReg = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)[a-zA-Z\d]{8,}$";

document.getElementById("inputFornavn").addEventListener("keyup",
		validerFornavn);
document.getElementById("inputEtternavn").addEventListener("keyup",
		validerEtternavn);
document.getElementById("inputMobil").addEventListener("keyup", validerMobil);
document.getElementById("inputPassord").addEventListener("keyup",
		validerPassord);
document.getElementById("inputPassordRepetert").addEventListener("keyup",
		validerLikePassord);
document.getElementById("inputKjonn").addEventListener("onclick",validerKjonn);

function validerFornavn() {
	let fornavn = document.getElementById("inputFornavn").value;
	let feilMelding = document.getElementById("feilFornavn");
	// console.log(!fornavnReg.test(fornavn));
	if (!fornavnReg.test(fornavn)) {
		feilMelding.innerHTML = 'ikke gyldig fornavn, husk stor forbokstav';
	} else {
		feilMelding.innerHTML = "";
	}
}
function validerEtternavn() {
	let etternavn = document.getElementById("inputEtternavn").value;
	let feilMelding = document.getElementById("feilEtternavn");

	if (!etternavnReg.test(etternavn)) {
		feilMelding.innerHTML = "ikke gyldig etternavn, husk stor forbokstav";
	} else {
		feilMelding.innerHTML = "";
	}
}
function validerMobil() {
	let mobil = document.getElementById("inputMobil").value;
	let feilMelding = document.getElementById("feilMobil");

	if (!mobilReg.test(mobil)) {
		feilMelding.innerHTML = "Ugyldig nummer. Kun 8 siffer";
	} else {
		feilMelding.innerHTML = "";
	}
}
function validerPassord() {
	let passord = document.getElementById("inputPassord").value;
	let feilMelding = document.getElementById("feilPassord");
	let middlePassord = document.getElementById("middlePassord");
	let strongPassord = document.getElementById("strongPassord");
	console.log(passord.length);
	if (passord.length < 6 || passord.match(passordReg)){
		middlePassord.innerHTML = "";
		strongPassord.innerHTML = "";
		feilMelding.innerHTML = "Ugyldig, passord for svakt";
	} else if (passord.length < 8) {
		strongPassord.innerHTML = "";
		feilMelding.innerHTML = "";
		middlePassord.innerHTML = "Middels passord styrke";	
	} else if(passord.length > 7) {
		feilMelding.innerHTML = "";
		middlePassord.innerHTML = "";
		strongPassord.innerHTML = "Serkt passord";
	}
}
function validerLikePassord() {
	let passord = document.getElementById("inputPassord").value;
	let passordRepetert = document.getElementById("inputPassordRepetert").value;
	let feilMelding = document.getElementById("feilPassordRepetert");
	if (passord !== passordRepetert) {
		feilMelding.innerHTML = "Passordene er ulike";
	} else {
		feilMelding.innerHTML = "";
	}
}
function validerKjonn() {
	
	let feilMelding = document.getElementById("feilKjonn");
		feilMelding.innerHTML = "";
}

