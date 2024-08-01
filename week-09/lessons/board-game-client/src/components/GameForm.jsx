// {
//     "title": "Cyber Pet Quest",
//     "rating": 5,
//     "minimumPlayers": 1,
//     "maximumPlayers": 4,
//     "checkedOut": false,
//     "weight": "LIGHT"
// }

import { useState } from "react";

const GameForm = () => {
  const [boardGame, setBoardGame] = useState({
    title: "",
    rating: 0,
    minimumPlayers: 0,
    maximumPlayers: 0,
    checkedOut: 0,
    weight: "CASUAL",
  });

  const handleChange = (event) => {
    let newValue;
    if (event.target.type === "checkbox") {
      newValue = event.target.checked;
    } else {
      newValue = event.target.value;
    }

    setBoardGame({
      ...boardGame,
      [event.target.name]: newValue,
    });

    // this changes state BEFORE calling the setter
    // because newBoardGame and boardGame have the same memory reference
    // const newBoardGame = boardGame
    // newBoardGame[event.target.name] = newValue
    // setBoardGame(newBoardGame)
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    console.log("I'm sending to the api!");
    console.log(boardGame);
  };

  return (
    <form onSubmit={handleSubmit}>
      <div>
        <label htmlFor="title-input">Title: </label>
        <input
          id="title-input"
          type="text"
          value={boardGame.title}
          onChange={handleChange}
          name="title"
        />
      </div>

      <div>
        <label htmlFor="rating-input">Rating: </label>
        <input
          id="rating-input"
          type="number"
          value={boardGame.rating}
          onChange={handleChange}
          name="rating"
        />
      </div>

      <div>
        <label htmlFor="minimumPlayers-input">Minimum Players: </label>
        <input
          id="minimumPlayers-input"
          type="number"
          value={boardGame.minimumPlayers}
          onChange={handleChange}
          name="minimumPlayers"
        />
      </div>

      <div>
        <label htmlFor="maximumPlayers-input">Maximum Players: </label>
        <input
          id="maximumPlayers-input"
          type="number"
          value={boardGame.maximumPlayers}
          onChange={handleChange}
          name="maximumPlayers"
        />
      </div>

      <div>
        <label htmlFor="checkedOut-input">Checked out: </label>
        <input
          id="checkedOut-input"
          type="checkbox"
          checked={boardGame.checkedOut}
          onChange={handleChange}
          name="checkedOut"
        />
      </div>

      <div>
        <label htmlFor="weight-input">Weight: </label>
        <select
          id="weight-input"
          value={boardGame.weight}
          onChange={handleChange}
          name="weight"
        >
          <option>CASUAL</option>
          <option>LIGHT</option>
          <option>MEDIUM</option>
          <option>HEAVY</option>
        </select>
      </div>

      <button type="submit">Make it!</button>
    </form>
  );
};

export default GameForm;
