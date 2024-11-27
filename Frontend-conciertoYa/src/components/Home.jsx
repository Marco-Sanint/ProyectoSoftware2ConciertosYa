// src/Home.jsx
import React, { useState, useEffect } from 'react';

// Importación de componentes
import Header from './Header';
import Artistas from './Artistas';
import Lugares from './Lugares';
import Eventos from './Eventos';
import Footer from './Footer';

const Home = () => {
  // Estado para los datos
  const [artistas, setArtistas] = useState([]);
  const [lugares, setLugares] = useState([]);
  const [eventos, setEventos] = useState([]);
  const [compras, setCompras] = useState(0);

  // Efecto para simular la carga de datos
  useEffect(() => {
    // Datos de los artistas
    setArtistas([
      { id: 1, nombre: 'Artista 1', genero_musical: 'Rock', redes_sociales: 'https://facebook.com/artista1' },
      { id: 2, nombre: 'Artista 2', genero_musical: 'Pop', redes_sociales: 'https://instagram.com/artista2' },
    ]);

    // Datos de los lugares
    setLugares([
      { id: 1, nombre: 'Lugar 1', direccion: 'Calle 123', capacidad: 5000, ciudad: 'Ciudad 1', imagen: '/imagenes/lugar1.jpg' },
      { id: 2, nombre: 'Lugar 2', direccion: 'Avenida 456', capacidad: 3000, ciudad: 'Ciudad 2', imagen: '/imagenes/lugar2.jpg' },
    ]);

    // Datos de los eventos
    setEventos([
      { id: 1, nombre: 'Concierto de Artista 1', fecha: '2024-05-20', hora: '20:00', descripcion: 'Un gran concierto de rock.', genero_musical: 'Rock', estado: 'programado', lugar_id: 1 },
      { id: 2, nombre: 'Concierto de Artista 2', fecha: '2024-06-15', hora: '19:00', descripcion: 'Un concierto pop inolvidable.', genero_musical: 'Pop', estado: 'programado', lugar_id: 2 },
    ]);
  }, []);

  // Función para manejar la compra de entradas
  const handleCompra = (eventoId) => {
    setCompras(compras + 1);
    alert('Compra realizada para el evento ID: ' + eventoId);
  };

  return (
    <div className="home-container">
      {/* Cabecera */}
      <Header />
      <div className="carousel">
        <Carousel />
      </div>
      
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

      {/* Sección de Lugares */}
      <Lugares lugares={lugares} />

      {/* Pie de página */}
      <Footer />
    </div>
  );
};

export default Home;
