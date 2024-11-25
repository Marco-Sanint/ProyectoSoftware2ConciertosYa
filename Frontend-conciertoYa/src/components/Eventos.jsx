import React from 'react';
import './Eventos.css'; // Asegúrate de que este archivo esté correctamente importado.
import { FaTicketAlt } from 'react-icons/fa';

const Eventos = () => {
  return (
    <div className="section eventos">
      <h2>Próximos Eventos</h2>
      <div className="grid">
        <div className="card-evento">
          <img src="ruta/a/imagen/evento1.jpg" alt="Concierto de Rock" />
          <h3>Concierto de Rock</h3>
          <p>Un evento lleno de energía y emoción, con los mejores artistas del género.</p>
          <a href="/comprar-boletos" className="btn-comprar">
            <FaTicketAlt /> Comprar Boletos
          </a>
        </div>

        <div className="card-evento">
          <img src="ruta/a/imagen/evento2.jpg" alt="Teatro en Vivo" />
          <h3>Teatro en Vivo</h3>
          <p>Una noche de teatro con una obra emocionante e inolvidable.</p>
          <a href="/comprar-boletos" className="btn-comprar">
            <FaTicketAlt /> Comprar Boletos
          </a>
        </div>

        <div className="card-evento">
          <img src="ruta/a/imagen/evento3.jpg" alt="Exposición de Arte" />
          <h3>Exposición de Arte Contemporáneo</h3>
          <p>Sumérgete en un mundo de arte contemporáneo y descubre obras únicas.</p>
          <a href="/comprar-boletos" className="btn-comprar">
            <FaTicketAlt /> Comprar Boletos
          </a>
        </div>

        {/* Agrega más eventos según sea necesario */}
      </div>
    </div>
  );
};

export default Eventos;
