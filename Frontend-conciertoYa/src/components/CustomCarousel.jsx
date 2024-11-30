import { useState } from 'react';
import Carousel from 'react-bootstrap/Carousel'; // Importación desde react-bootstrap
import './CustomCarousel.css'; // Archivo de estilos personalizados

function CustomCarousel() {
  const [index, setIndex] = useState(0);

  const handleSelect = (selectedIndex) => {
    setIndex(selectedIndex);
  };

  return (
    <Carousel
      activeIndex={index}
      onSelect={handleSelect}
      interval={3000} // Cambia cada 3 segundos automáticamente
      fade // Transición suave
      indicators={true} // Muestra indicadores abajo
    >
      <Carousel.Item>
        <img src="/imagenes/Bless.jpeg" alt="Bless" />
      </Carousel.Item>
      <Carousel.Item>
        <img src="/imagenes/cantina.jpg" alt="Cantina" />
      </Carousel.Item>
      <Carousel.Item>
        <img src="/imagenes/LuisAlfonso.jpeg" alt="Luis Alfonso" />
      </Carousel.Item>
      <Carousel.Item>
        <img src="/imagenes/Maluma.jpg" alt="Maluma" />
      </Carousel.Item>
      <Carousel.Item>
        <img src="/imagenes/superConcierto.jpg" alt="Super Concierto" />
      </Carousel.Item>
    </Carousel>
  );
}

export default CustomCarousel;
