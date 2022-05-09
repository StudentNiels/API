
console.log("hai"); 

fetch('127.0.0.1:5000')
    .then(res=>res.json())
    .then(data=>console.log(data));

function fillTableWithParameters(tbl) {
    let url = new URL('https://localhost:5000/deathcauses');
    url.searchParams.sort();
    let keys = url.searchParams.keys();
  
    for (let key of keys) {
      let val = url.searchParams.get(key);
      let row = document.createElement("tr");
      let cell = document.createElement("td");
      cell.innerText = key;
      row.appendChild(cell);
      cell = document.createElement("td");
      cell.innerText = val;
      row.appendChild(cell);
      tbl.appendChild(row);
    };
  }

//fetch('127.0.0.1:5000/deathcauses') //call the fetch function passing the url of the API as a parameter
//        .then(res=>res.json())
//        .then(json=>console.log(json));