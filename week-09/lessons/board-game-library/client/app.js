const populateGames = () => {
    const html = games.map(g => `<tr>
        <td>
        </td>
        </tr>`
    ).join("");

    document.querySelector(`tbody`).innerHTML = html;
}

const viewgame = (gameId) =>{
    
}

populateGames();