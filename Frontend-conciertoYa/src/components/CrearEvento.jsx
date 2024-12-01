import React, { useState } from 'react';
import { useDropzone } from 'react-dropzone';
import axios from 'axios';
import './CrearEvento.css';
import Header from './Header';
import Footer from './Footer';
import Modal from './Modal'; // Importamos el modal

const CrearEvento = () => {
    const [evento, setEvento] = useState({
        nombre: '',
        fecha: '',
        hora: '',
        descripcion: '',
        generoMusical: '',
        estado: 'PENDIENTE',
        imagenCartel: '',
        lugarId: '',
    });

    const [lugares, setLugares] = useState([
        { id: 1, nombre: 'Teatro Colón' },
        { id: 2, nombre: 'Auditorio Nacional' },
        { id: 3, nombre: 'Parque Simón Bolívar' },
    ]);

    // Estado para controlar la visibilidad del modal
    const [showModal, setShowModal] = useState(false);

    // Configuración para la zona de drop
    const { getRootProps, getInputProps } = useDropzone({
        accept: 'image/*', // Solo permitir imágenes
        onDrop: (acceptedFiles) => {
            const file = acceptedFiles[0];
            setEvento({
                ...evento,
                imagenCartel: URL.createObjectURL(file) // Convertir la imagen a una URL local
            });
        },
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setEvento({
            ...evento,
            [name]: value
        });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Aquí agregas la lógica para crear el evento (puedes agregar axios para enviarlo a la API)
        console.log('Evento creado:', evento);

        // Mostrar el modal después de enviar el evento
        setShowModal(true);
    };

    const handleModalClose = () => {
        setShowModal(false); // Cerrar el modal
        // Aquí podrías redirigir al usuario al home, si lo necesitas
        window.location.href = '/'; // O usar un `useNavigate` si estás usando react-router
    };

    return (
        <div className="form-container">
            <Header />
            <div className="form-header">
                <h2 className="form-title">¡Organiza un evento inolvidable!</h2>
            </div>
            <div className="form-details">
                <form onSubmit={handleSubmit}>
                    <div className="form-field">
                        <label>Nombre del Evento</label>
                        <input
                            type="text"
                            name="nombre"
                            value={evento.nombre}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-field">
                        <label>Fecha</label>
                        <input
                            type="date"
                            name="fecha"
                            value={evento.fecha}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-field">
                        <label>Hora</label>
                        <input
                            type="time"
                            name="hora"
                            value={evento.hora}
                            onChange={handleChange}
                            required
                        />
                    </div>
                    <div className="form-field">
                        <label>Descripción</label>
                        <textarea
                            name="descripcion"
                            value={evento.descripcion}
                            onChange={handleChange}
                        ></textarea>
                    </div>
                    <div className="form-field">
                        <label>Género Musical</label>
                        <input
                            type="text"
                            name="generoMusical"
                            value={evento.generoMusical}
                            onChange={handleChange}
                        />
                    </div>

                    {/* Selección del Lugar */}
                    <div className="form-field">
                        <label>Lugar</label>
                        <select
                            name="lugarId"
                            value={evento.lugarId}
                            onChange={handleChange}
                            required
                        >
                            <option value="">Seleccione un lugar</option>
                            {lugares.map(lugar => (
                                <option key={lugar.id} value={lugar.id}>
                                    {lugar.nombre}
                                </option>
                            ))}
                        </select>
                    </div>

                    {/* Área de Drag and Drop para la imagen */}
                    <div className="form-field">
                        <label>Imagen del Cartel</label>
                        <div {...getRootProps()} className="dropzone">
                            <input {...getInputProps()} />
                            <p>Arrastra y suelta una imagen aquí, o haz clic para seleccionar</p>
                            {evento.imagenCartel && (
                                <img
                                    src={evento.imagenCartel}
                                    alt="Imagen seleccionada"
                                    className="selected-image"
                                />
                            )}
                        </div>
                    </div>

                    <button type="submit" className="form-btn">Crear Evento</button>
                </form>
            </div>
            <Footer />
            
            {/* Modal que se muestra después de crear el evento */}
            <Modal 
                showModal={showModal} 
                handleClose={handleModalClose} 
            />
        </div>
    );
};

export default CrearEvento;
