import React, { useState, useEffect } from 'react';

// Importación de componentes
import Header from './Header';
import Artistas from './Artistas';
import Lugares from './Lugares';
import Eventos from './Eventos';
import Footer from './Footer';
import "./Home.css";  


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
      <Header  />

      {/* Sección de Artistas */}
      <Artistas artistas={artistas} />
      
      {/* Sección de Lugares */}
      <Lugares lugares={lugares} />

      {/* Sección de Eventos */}
      <Eventos eventos={eventos} handleCompra={handleCompra} />

      <div className="card-container">
        <div className="card-crearArtista">
            <h3>¿Quieres ser parte de nuestros artistas?</h3>
            <a href="/nuevoartista" className="btn btn-primary">¡Crea tu perfil!</a>
        </div>
        <div className="card-crearEvento">
            <h3>¿Quieres ser parte de nuestros eventos?</h3>
            <a href="/nuevoevento" className="btn btn-primary">¡Crea tu evento!</a>
        </div>
        <div className="card-crearlugar">
            <h3>¿Quieres ser parte de nuestros lugares de eventos ?</h3>
            <a href="/nuevolugar" className="btn btn-primary">¡Crea un Lugar!</a>
        </div>
      </div>

      {/* Pie de página */}
      <Footer />
    </div>
  );
};

export default Home;
