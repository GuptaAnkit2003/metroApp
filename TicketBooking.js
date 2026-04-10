import { useState } from "react";
import { buyTicket } from "../api/ticketService";

export default function TicketBooking() {
  const [source, setSource] = useState("");
  const [destination, setDestination] = useState("");
  const [ticketId, setTicketId] = useState("");

  const handleBook = async () => {
    if (!source || !destination) {
      alert("Please select source and destination");
      return;
    }

    try {
      const res = await buyTicket(source, destination);

      console.log("Backend Response:", res.data);

      // safer handling
      setTicketId(res.data?.id || res.data?.ticketId || res.data);

    } catch (err) {
      console.log("ERROR:", err.response?.data || err.message);
      alert("❌ Ticket booking failed - check backend");
    }
  };

  return (
    <div style={styles.container}>
      <h2>🎫 Book Metro Ticket</h2>

      <input
        placeholder="Source (e.g. A)"
        value={source}
        onChange={(e) => setSource(e.target.value)}
        style={styles.input}
      />

      <input
        placeholder="Destination (e.g. C)"
        value={destination}
        onChange={(e) => setDestination(e.target.value)}
        style={styles.input}
      />

      <button onClick={handleBook} style={styles.button}>
        Buy Ticket
      </button>

      {ticketId && (
        <div style={styles.ticketBox}>
          🎟️ Ticket Generated: <b>{ticketId}</b>
        </div>
      )}
    </div>
  );
}

const styles = {
  container: {
    padding: 20,
    border: "1px solid #ccc",
    width: 350,
    margin: "20px auto",
    borderRadius: 10,
    textAlign: "center",
  },
  input: {
    display: "block",
    margin: "10px auto",
    padding: 10,
    width: "80%",
  },
  button: {
    padding: "10px 20px",
    backgroundColor: "green",
    color: "white",
    border: "none",
    cursor: "pointer",
  },
  ticketBox: {
    marginTop: 15,
    padding: 10,
    backgroundColor: "#f0f0f0",
  },
};