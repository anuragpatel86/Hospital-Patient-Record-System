let patients = {};

function showAddPatient() {
    let id = prompt("Enter Patient ID:");
    if (!id || patients[id]) {
        document.getElementById("output").innerHTML = "Invalid or duplicate ID!";
        return;
    }

    let name = prompt("Enter Name:");
    let age = prompt("Enter Age:");
    let disease = prompt("Enter Disease:");

    patients[id] = { id, name, age, disease };
    document.getElementById("output").innerHTML = "✅ Patient added successfully!";
}

function showViewPatient() {
    let id = prompt("Enter Patient ID to view:");
    if (!id) return;

    if (patients[id]) {
        const p = patients[id];
        document.getElementById("output").innerHTML =
            `<b>Patient ID:</b> ${p.id}<br><b>Name:</b> ${p.name}<br><b>Age:</b> ${p.age}<br><b>Disease:</b> ${p.disease}`;
    } else {
        document.getElementById("output").innerHTML = "❌ Patient not found!";
    }
}

function showUpdatePatient() {
    let id = prompt("Enter Patient ID to update:");
    if (!id || !patients[id]) {
        document.getElementById("output").innerHTML = "Patient not found!";
        return;
    }

    let name = prompt("Enter new Name:", patients[id].name);
    let age = prompt("Enter new Age:", patients[id].age);
    let disease = prompt("Enter new Disease:", patients[id].disease);

    patients[id] = { id, name, age, disease };
    document.getElementById("output").innerHTML = "✅ Patient updated successfully!";
}

function showDeletePatient() {
    let id = prompt("Enter Patient ID to delete:");
    if (!id) return;

    if (patients[id]) {
        delete patients[id];
        document.getElementById("output").innerHTML = "🗑️ Patient deleted successfully!";
    } else {
        document.getElementById("output").innerHTML = "❌ Patient not found!";
    }
}

function showAllPatients() {
    if (Object.keys(patients).length === 0) {
        document.getElementById("output").innerHTML = "No patient records found!";
        return;
    }

    let result = "<h3>All Patients:</h3>";
    for (let id in patients) {
        let p = patients[id];
        result += `ID: ${p.id}, Name: ${p.name}, Age: ${p.age}, Disease: ${p.disease}<br>`;
    }

    document.getElementById("output").innerHTML = result;
}

function showSearch() {
    let query = prompt("Enter name or disease to search:");
    if (!query) return;

    let result = "<h3>Search Results:</h3>";
    let found = false;

    for (let id in patients) {
        let p = patients[id];
        if (p.name.toLowerCase().includes(query.toLowerCase()) ||
            p.disease.toLowerCase().includes(query.toLowerCase())) {
            result += `ID: ${p.id}, Name: ${p.name}, Age: ${p.age}, Disease: ${p.disease}<br>`;
            found = true;
        }
    }

    document.getElementById("output").innerHTML = found ? result : "❌ No matching patients found!";
}

function exitSystem() {
    document.getElementById("output").innerHTML = "System Closed!";
}