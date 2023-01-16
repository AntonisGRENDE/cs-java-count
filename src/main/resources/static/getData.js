async function getData() {
    let x = document.getElementById("userInput").value;
    document.getElementById("mydiv").classList.add("divStyles")


    await fetch(("http://localhost:8080"), {
        method: 'POST',
        body: JSON.stringify({"path": x }),
        headers: { 'Content-Type': 'application/json' }
    }).then(data => data.text())
      .then(data => document.getElementById("mydiv").innerHTML = data)
}