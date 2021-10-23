function yesnoCheck() {
    if (document.getElementById('yesCheck').checked) {
        document.getElementById('ifStudent').style.visibility = 'visible';
    }
    else document.getElementById('ifStudent').style.visibility = 'hidden';
}