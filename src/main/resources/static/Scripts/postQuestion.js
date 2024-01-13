document.getElementById('searchQuestions').onsubmit = function() {
   window.location = 'http://localhost:8080/questions/new/' + document.getElementById('questionTitle').value + '/' + document.getElementById('questionContent').value;;
   return false;
}