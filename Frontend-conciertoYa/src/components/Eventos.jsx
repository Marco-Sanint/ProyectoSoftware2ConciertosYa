import React from 'react';
import './Eventos.css';
import { FaTicketAlt } from 'react-icons/fa';
import { Link } from 'react-router-dom';

const Eventos = () => {
  const eventos = [
    {
      id: 1,
      imagen: "/imagenes/rock1.webp",
      nombre: "Concierto de Rock",
      descripcion: "Un evento lleno de energía y emoción, con los mejores artistas del género.",
    },
    {
      id: 2,
      imagen: "/imagenes/teatro1.jpg",
      nombre: "Teatro en Vivo",
      descripcion: "Una noche de teatro con una obra emocionante e inolvidable.",
    },
    {
      id: 3,
      imagen: "/imagenes/arte1.webp",
      nombre: "Exposición de Arte Contemporáneo",
      descripcion: "Sumérgete en un mundo de arte contemporáneo y descubre obras únicas.",
    },
  ];

  return (
    <div className="section eventos">
      <h2>Próximos Eventos</h2>
      <div className="grid">
        {eventos.map((evento) => (
          <div className="card-evento" key={evento.id}>
            <img src={evento.imagen} alt={evento.nombre} />
            <h3>{evento.nombre}</h3>
            <p>{evento.descripcion}</p>
            <Link
              to="/comprar-boletos"
              state={evento}  // Pasamos el evento como estado
              className="btn-comprar"
            >
              <FaTicketAlt /> Comprar Boletos
            </Link>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Eventos;
