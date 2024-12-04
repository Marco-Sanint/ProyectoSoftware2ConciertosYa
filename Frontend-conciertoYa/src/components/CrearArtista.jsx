import React, { useState } from 'react';
import './CrearArtista.css'; 
import Header from './Header';
import Footer from './Footer';
import Modal from './Modal'; 
import RedesSociales from './RedesSociales';

const CrearArtista = () => {
    const [artista, setArtista] = useState({
        nombre: '',
        generoMusical: '',
        redesSociales: '',
    });

    const [showModal, setShowModal] = useState(false);
    const [error, setError] = useState(''); // Para manejar errores

    const handleChange = (e) => {
        const { name, value } = e.target;
        setArtista({
            ...artista,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        // Validar que los campos obligatorios no estén vacíos
        if (!artista.nombre || !artista.generoMusical) {
            setError('Por favor completa los campos obligatorios.');
            return;
        }

        try {
            // Realizar la solicitud POST al backend
            const response = await fetch('http://localhost:8080/api/artistas', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify(artista),
            });

            if (response.ok) {
                // Éxito en la creación del artista
                const data = await response.json();
                console.log('Artista creado:', data);

                // Mostrar el modal de éxito
                setShowModal(true);
                setError('');
            } else {
                // Manejar errores del backend
                const errorData = await response.json();
                setError(errorData.message || 'Error al crear el artista');
            }
        } catch (err) {
            console.error('Error al conectar con la API:', err);
            setError('No se pudo conectar con el servidor.');
        }
    };

    const handleModalClose = () => {
        setShowModal(false);
        // Redirigir al Home
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
                            required
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
                {error && <p className="error-text">{error}</p>}
            </div>
            <Footer />

            {/* Modal de confirmación */}
            <Modal 
                showModal={showModal} 
                handleClose={handleModalClose} 
                message="¡Artista creado exitosamente!" // Mensaje para el modal
            />
        </div>
    );
};

export default CrearArtista;
