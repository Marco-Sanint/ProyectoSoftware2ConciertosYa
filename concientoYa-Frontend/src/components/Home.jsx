import React, { useEffect, useState } from 'react';
import './Home.css';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faShoppingCart } from '@fortawesome/free-solid-svg-icons';

const Home = () => {
  const [artistas, setArtistas] = useState([]);
  const [lugares, setLugares] = useState([]);
  const [eventos, setEventos] = useState([]);
  const [compras, setCompras] = useState(0); // Contador de compras

  useEffect(() => {
    // Simulación de datos de artistas
    setArtistas([
      { id: 1, nombre: 'Artista 1', genero_musical: 'Rock', redes_sociales: 'https://facebook.com/artista1' },
      { id: 2, nombre: 'Artista 2', genero_musical: 'Pop', redes_sociales: 'https://instagram.com/artista2' },
    ]);

    // Simulación de datos de lugares
    setLugares([
      { id: 1, nombre: 'Lugar 1', direccion: 'Calle 123', capacidad: 5000, ciudad: 'Ciudad 1', imagen: '/imagenes/lugar1.jpg' },
      { id: 2, nombre: 'Lugar 2', direccion: 'Avenida 456', capacidad: 3000, ciudad: 'Ciudad 2', imagen: '/imagenes/lugar2.jpg' },
    ]);

    // Simulación de datos de eventos
    setEventos([
      { id: 1, nombre: 'Concierto de Artista 1', fecha: '2024-05-20', hora: '20:00', descripcion: 'Un gran concierto de rock.', genero_musical: 'Rock', estado: 'programado', lugar_id: 1 },
      { id: 2, nombre: 'Concierto de Artista 2', fecha: '2024-06-15', hora: '19:00', descripcion: 'Un concierto pop inolvidable.', genero_musical: 'Pop', estado: 'programado', lugar_id: 2 },
    ]);
  }, []);

  const handleCompra = (eventoId) => {
    setCompras(compras + 1);
    alert(`Has comprado una entrada para: ${eventos.find(evento => evento.id === eventoId).nombre}`);
  };

  return (
    <div className="home">
      <header className="hero">
        <h1>Bienvenidos a ConciertoYa</h1>
        <p>Encuentra los mejores conciertos, compra tus entradas y disfruta del mejor espectáculo.</p>
      </header>

      <section className="section artistas">
        <h2>Artistas Destacados</h2>
        <div className="grid">
          {artistas.map(artista => (
            <div key={artista.id} className="card">
              <h3>{artista.nombre}</h3>
              <p>Género: {artista.genero_musical}</p>
              <a href={artista.redes_sociales} target="_blank" rel="noopener noreferrer" className="social-link">Redes Sociales</a>
            </div>
          ))}
        </div>
      </section>

      <section className="section lugares">
        <h2>Lugares de Eventos</h2>
        <div className="grid">
          {lugares.map(lugar => (
            <div key={lugar.id} className="card lugar-card">
              <h3>{lugar.nombre}</h3>
              <p>Dirección: {lugar.direccion}</p>
              <p>Capacidad: {lugar.capacidad}</p>
              <p>Ciudad: {lugar.ciudad}</p>
              <img src={lugar.imagen} alt={lugar.nombre} className="imagen-lugar" />
            </div>
          ))}
        </div>
      </section>

      <section className="section eventos">
        <h2>Eventos Próximos</h2>
        <div className="grid">
          {eventos.map(evento => (
            <div key={evento.id} className="card evento-card" onClick={() => handleCompra(evento.id)}>
              <h3>{evento.nombre}</h3>
              <p>Fecha: {evento.fecha}</p>
              <p>Hora: {evento.hora}</p>
              <p>Descripción: {evento.descripcion}</p>
              <p>Género: {evento.genero_musical}</p>
              <p>Estado: {evento.estado}</p>
              <button className="btn-comprar">
                <FontAwesomeIcon icon={faShoppingCart} /> Comprar Entradas
              </button>
            </div>
          ))}
        </div>
      </section>

      {/* Icono de carrito de compras */}
      <div className="cart-icon" onClick={() => alert('¡Carrito de compras!')}>
        <FontAwesomeIcon icon={faShoppingCart} size="2x" />
        {compras > 0 && <span className="cart-count">{compras}</span>}
      </div>
    </div>
  );
};

export default Home;