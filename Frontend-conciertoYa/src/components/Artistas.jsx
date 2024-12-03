import React from 'react';
import Slider from 'react-slick';
import { FaInstagram, FaTwitter, FaFacebook } from 'react-icons/fa';
import './Artistas.css';
import { FaTicketAlt } from 'react-icons/fa';
const Artistas = () => {
  const settings = {
    dots: true,
    infinite: true,
    speed: 500,
    slidesToShow: 3,
    slidesToScroll: 1,
    autoplay: true,   // Habilitar el autoplay
    autoplaySpeed: 3000, // Intervalo de tiempo entre cada slide (en milisegundos)
    responsive: [
      {
        breakpoint: 1024,
        settings: {
          slidesToShow: 2,
          slidesToScroll: 1,
        },
      },
      {
        breakpoint: 600,
        settings: {
          slidesToShow: 1,
          slidesToScroll: 1,
        },
      },
    ],
  };

  return (
    <div className="section artistas">
      <h2>Artistas Destacados</h2>
      <Slider {...settings} className="carousel">
        <div className="card-artista">
          <img src="/imagenes/artista1.jpg" alt="Artista 1" />
          <h3>Artista 1</h3>
          <p>Descripción del artista 1</p>
          <a href="/Seat" className="btn-comprar">
            <FaTicketAlt /> Comprar Boletos
          </a>
          <div className="social-links">
            <a href="https://instagram.com" className="social-link"><FaInstagram /></a>
            <a href="https://twitter.com" className="social-link"><FaTwitter /></a>
            <a href="https://facebook.com" className="social-link"><FaFacebook /></a>
          </div>
        </div>

        <div className="card-artista">
          <img src="/imagenes/artista2.jpg" alt="Artista 2" />
          <h3>Artista 2</h3>
          <p>Descripción del artista 2</p>
          <a href="/Seat" className="btn-comprar">
            <FaTicketAlt /> Comprar Boletos
          </a>
          <div className="social-links">
            <a href="https://instagram.com" className="social-link"><FaInstagram /></a>
            <a href="https://twitter.com" className="social-link"><FaTwitter /></a>
            <a href="https://facebook.com" className="social-link"><FaFacebook /></a>
          </div>
        </div>

        <div className="card-artista">
          <img src="/imagenes/artista3.jpg" alt="Artista 3" />
          <h3>Artista 3</h3>
          <p>Descripción del artista 3</p>
          <a href="/Seat" className="btn-comprar">
            <FaTicketAlt /> Comprar Boletos
          </a>
          <div className="social-links">
            <a href="https://instagram.com" className="social-link"><FaInstagram /></a>
            <a href="https://twitter.com" className="social-link"><FaTwitter /></a>
            <a href="https://facebook.com" className="social-link"><FaFacebook /></a>
          </div>
        </div>
          
      </Slider>
    </div>
  );
};

export default Artistas;
