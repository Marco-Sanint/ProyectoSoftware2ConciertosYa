import React, { useEffect, useState } from 'react';
import './Home.css';
import Header from './Header';
import Footer from './Footer';
import CustomCarousel from './CustomCarousel'; // Importa el carrusel

const Home = () => {
  const [artistas, setArtistas] = useState([]);
  const [lugares, setLugares] = useState([]);
  const [eventos, setEventos] = useState([]);
  const [compras, setCompras] = useState(0);

  useEffect(() => {
    setArtistas([
      { id: 1, nombre: 'Artista 1', genero_musical: 'Rock', redes_sociales: 'https://facebook.com/artista1' },
      { id: 2, nombre: 'Artista 2', genero_musical: 'Pop', redes_sociales: 'https://instagram.com/artista2' },
    ]);

    setLugares([
      { id: 1, nombre: 'Lugar 1', direccion: 'Calle 123', capacidad: 5000, ciudad: 'Ciudad 1', imagen: '/imagenes/lugar1.jpg' },
      { id: 2, nombre: 'Lugar 2', direccion: 'Avenida 456', capacidad: 3000, ciudad: 'Ciudad 2', imagen: '/imagenes/lugar2.jpg' },
    ]);

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
      <Header />

      {/* Carrusel agregado aquí */}
      <CustomCarousel />
      
      <section className="section artistas">
        <h2>Artistas Destacados</h2>
        <div className="horizontal-scroll">
          {artistas.map(artista => (
            <div key={artista.id} className="artista-card">
              <h3>{artista.nombre}</h3>
              <p>Género: {artista.genero_musical}</p>
              <a href={artista.redes_sociales} target="_blank" rel="noopener noreferrer" className="social-link">Redes Sociales</a>
            </div>
          ))}
        </div>
      </section>

      <section className="section eventos">
        <h2>Eventos Próximos</h2>
        <div className="horizontal-scroll">
          {eventos.map(evento => (
            <div key={evento.id} className="evento-card" onClick={() => handleCompra(evento.id)}>
              <h3>{evento.nombre}</h3>
              <p>Fecha: {evento.fecha}</p>
              <p>Hora: {evento.hora}</p>
              <p>Descripción: {evento.descripcion}</p>
              <button className="btn-comprar">Comprar Entradas</button>
            </div>
          ))}
        </div>
      </section>

      <Footer />
    </div>
  );
};

export default Home;
