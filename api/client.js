fetch('localhost:5000') //call the fetch function passing the url of the API as a parameter
.then(res=>res.json())
.then(json=>console.log(json));