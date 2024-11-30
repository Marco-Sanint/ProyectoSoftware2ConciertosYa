import React, { useState, useEffect } from 'react';
import './Carousel.css';

const images = [
  { src: "/imagenes/florecita_rockera.jpg", title: "Florecita Rockera", venue: "Teatro Astor Plaza, Bogotá", dates: "22 Nov - 1 Dic" },
  { src: "/imagenes/pink_floyd.jpg", title: "Pink Floyd Filarmónico", venue: "Teatro Jorge Eliécer Gaitán, Bogotá", date: "22 Nov" },
  { src: "/imagenes/pereira_music_fest.jpg", title: "Pereira Music Fest", venue: "Teatro Santiago Londoño, Pereira", dates: "25 Nov - 30 Nov" },
  { src: "/imagenes/scrooge.jpg", title: "Scrooge y los Fantasmas de la Navidad", venue: "Teatro Colsubsidio, Bogotá", dates: "23 Nov - 22 Dic" },
  { src: "/imagenes/martinez_brothers.jpg", title: "The Martinez Brothers", venue: "Lourdes Music Hall, Bogotá", date: "30 Nov" }
];

const Carousel = () => {
  const [currentIndex, setCurrentIndex] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentIndex(prevIndex => (prevIndex + 1) % images.length);
    }, 3000);
    return () => clearInterval(interval);
  }, []);

  return (
    <div className="carousel">
      <div className="carousel-inner" style={{ transform: `translateX(-${currentIndex * 100}%)` }}>
        {images.map((image, index) => (
          <div className="carousel-item" key={index}>
            <img src={image.src} alt={image.title} />
            <div className="carousel-caption">
              <h3>{image.title}</h3>
              <p>{image.venue}</p>
              <p>{image.dates}</p>
            </div>
          </div>
        ))}
      </div>
      <div className="carousel-indicators">
        {images.map((_, index) => (
          <button
            key={index}
            className={currentIndex === index ? 'active' : ''}
            onClick={() => setCurrentIndex(index)}
          />
        ))}
      </div>
    </div>
  );
};

export default Carousel;
