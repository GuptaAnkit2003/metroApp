import { useState } from "react";
import { entryTicket, exitTicket } from "../api/ticketService";

export default function TicketActions() {
  const [ticketId, setTicketId] = useState("");
  const [status, setStatus] = useState("");

  // 🚇 ENTRY
  const handleEntry = async () =>
     {console.log("Ticket ID sent (ENTRY):", ticketId);  
    if (!ticketId) {
      setStatus("❌ Please enter Ticket ID");
      return;
    }

    try {
      const res = await entryTicket(ticketId);
      setStatus(res.data || "✔ Entry Successful");
    } catch (err) {
      console.log(err);
      setStatus("❌ Entry Failed (Invalid / Used / Expired)");
    }
  };

  // 🚪 EXIT
  const handleExit = async () => {
    console.log("Ticket ID sent (ENTRY):", ticketId);  
    if (!ticketId) {
      setStatus("❌ Please enter Ticket ID");
      return;
    }

    try {
      const res = await exitTicket(ticketId);
      setStatus(res.data || "✔ Exit Successful");
    } catch (err) {
      console.log(err);
      setStatus("❌ Exit Failed (Not Entered / Already Used / Expired)");
    }
  };

  return (
    <div style={styles.container}>
      <h2>🎟️ Use Ticket</h2>

      <input
        type="text"
        placeholder="Enter Ticket ID"
        value={ticketId}
        onChange={(e) => setTicketId(e.target.value)}
        style={styles.input}
      />

      <div>
        <button onClick={handleEntry} style={styles.entryBtn}>
          ENTRY 🚇
        </button>

        <button onClick={handleExit} style={styles.exitBtn}>
          EXIT 🚪
        </button>
      </div>

      {status && <p style={styles.status}>{status}</p>}
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
    padding: 10,
    width: "80%",
    marginBottom: 10,
  },
  entryBtn: {
    backgroundColor: "blue",
    color: "white",
    padding: 10,
    marginRight: 10,
    border: "none",
    cursor: "pointer",
  },
  exitBtn: {
    backgroundColor: "red",
    color: "white",
    padding: 10,
    border: "none",
    cursor: "pointer",
  },
  status: {
    marginTop: 10,
    fontWeight: "bold",
  },
};