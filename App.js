import TicketBooking from "./components/TicketBooking";
import TicketActions from "./components/TicketActions";

function App() {
  return (
    <div style={{ textAlign: "center", fontFamily: "Arial" }}>
      <h1>🚇 Metro Ticket Booking System</h1>

      <TicketBooking />

      <hr />

      <TicketActions />
    </div>
  );
}

export default App;