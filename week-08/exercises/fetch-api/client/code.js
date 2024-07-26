const url = "http://localhost:8080/api/capsule";
const capsuleContainer = document.getElementById('capsules');
const messages = document.getElementById('messages');

/**
 * Displays the capsules in the capsule container.
 */
async function displayCapsules() {
  // TODO Use the Fetch API to get the capsules from the API.
  const init = {
    method: "GET",
    headers: {
      Accept: "application/json",
    },
  };

  const capsules = await fetch(url, init);

  if (capsules.status !== 200) {
    console.log(`Bad status: ${capsules.status}`);
    return Promise.reject("response is not 200 OK");
  }

  const json = await capsules.json();


  const capsulesHtml = json.map((capsule) => `
    <div>
      <span class="badge badge-pill ${capsule.guestName ? 'badge-warning' : 'badge-success'}">Capsule #${capsule.capsuleNumber}</span>
      &nbsp;
      <span>${capsule.guestName ? capsule.guestName : 'Unoccupied'}</span>
    </div>
  `);

  capsuleContainer.innerHTML = capsulesHtml.join('');
}

/**
 * Resets the check-in form.
 */
function resetCheckInForm() {
  document.getElementById('guestName').value = '';
  document.getElementById('checkInCapsuleNumber').value = '';
}

/**
 * Resets the check-out form.
 */
function resetCheckOutForm() {
  document.getElementById('checkOutCapsuleNumber').value = '';
}

/**
 * Displays the error messages in the messages container.
 * @param {string[]} errorMessages - The error messages to display.
 */
function displayErrorMessages(errorMessages) {
  messages.className = 'alert alert-danger';
  errorMessagesHtml = errorMessages.map((errorMessage) => `<li>${errorMessage}</li>`);
  messages.innerHTML = `
    <p>The following errors were found:</p>
    <ul>${errorMessagesHtml.join('')}</ul>
  `;
}

/**
 * Displays the success message in the messages container.
 * @param {string} message - The success message to display.
 */
function displaySuccessMessage(message) {
  messages.className = 'alert alert-success';
  messages.innerText = message;
}

/**
 * Handles the check-in form submission.
 * @param {Event} evt - The event object.
 */
function checkIn(evt) {
  evt.preventDefault();

  const guestName = document.getElementById('guestName').value.trim();
  const capsuleNumber = parseInt(
    document.getElementById('checkInCapsuleNumber').value,
    10
  );

  // TODO Use the Fetch API to check in the guest using the API.
  // TODO If the response status is 400, display the error messages using the `displayErrorMessages()` function.
  // TODO If the response status is 201, display a success message using the `displaySuccessMessage()` function.

  resetCheckInForm();
  displayCapsules();
}

/**
 * Handles the check-out form submission.
 * @param {Event} evt - The event object.
 */
function checkOut(evt) {
  evt.preventDefault();

  let capsuleNumber = parseInt(
    document.getElementById('checkOutCapsuleNumber').value,
    10
  );

  if (isNaN(capsuleNumber)) {
    displayErrorMessages(['Capsule number is required.']);
    return;
  }

  // TODO Use the Fetch API to check out the guest using the API.
  // TODO If the response status is 400, display the error messages using the `displayErrorMessages()` function.
  // TODO If the response status is 204, display a success message using the `displaySuccessMessage()` function.

  resetCheckOutForm();
  displayCapsules();
}

displayCapsules();
