import React, { useState } from 'react';
import './CrearArtista.css'; // Estilos del formulario
import Header from './Header';
import Footer from './Footer';
import Modal from './Modal'; // Modal de confirmación
import RedesSociales from './RedesSociales';
const CrearArtista = () => {
    const [artista, setArtista] = useState({
        nombre: '',
        generoMusical: '',
        redesSociales: '',
    });

    const [showModal, setShowModal] = useState(false);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setArtista({
            ...artista,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        console.log('Artista creado:', artista);

        // Aquí podrías agregar la lógica para guardar el artista (ej. Axios para la API)
        
        // Mostrar el modal después de crear el artista
        setShowModal(true);
    };

    const handleModalClose = () => {
        setShowModal(false);
        // Redirigir al Home, podrías usar `window.location.href` o `useNavigate`
        window.location.href = '/'; // Usando redirección simple
    };

    return (
        <div className="form-container">
            <Header />
            <div className="form-header">
                <h2 className="form-title">¡Agrega un nuevo artista!</h2>
            </div>
            <div className="form-details">
                <form onSubmit={handleSubmit}>
                    <div className="form-field">
                        <label>Nombre del Artista</label>
                        <input
                            type="text"
                            name="nombre"
                            value={artista.nombre}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-field">
                        <label>Género Musical</label>
                        <input
                            type="text"
                            name="generoMusical"
                            value={artista.generoMusical}
                            onChange={handleChange}
                        />
                    </div>
                    <div className="form-field">
                        <label>Redes Sociales</label>
                        <RedesSociales />
                        <textarea
                            name="redesSociales"
                            value={artista.redesSociales}
                            onChange={handleChange}
                        ></textarea>
                    </div>

                    <button type="submit" className="form-btn">Crear Artista</button>
                </form>
            </div>
            <Footer />

            {/* Modal de confirmación */}
            <Modal 
                showModal={showModal} 
                handleClose={handleModalClose} 
            />
        </div>
    );
};

export default CrearArtista;
