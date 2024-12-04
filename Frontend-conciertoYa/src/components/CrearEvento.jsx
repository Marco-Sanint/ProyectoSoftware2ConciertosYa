import React, { useState, useEffect } from 'react';
import { useDropzone } from 'react-dropzone';
import axios from 'axios';
import './CrearEvento.css';
import Header from './Header';
import Footer from './Footer';
import Modal from './Modal';

const CrearEvento = () => {
    const [evento, setEvento] = useState({
        nombre: '',
        fecha: '',
        hora: '',
        descripcion: '',
        generoMusical: '',
        estado: 'PROGRAMADO', 
        lugarId: '',  
    });

    const [imagenCartel, setImagenCartel] = useState(null); 
    const [lugares, setLugares] = useState([]); 
    const [showModal, setShowModal] = useState(false);
    const [error, setError] = useState('');

    const { getRootProps, getInputProps } = useDropzone({
        accept: 'image/*',
        onDrop: (acceptedFiles) => {
            const file = acceptedFiles[0];
            setImagenCartel(file);
        },
    });

    useEffect(() => {
        axios.get('http://localhost:8080/api/lugares')
            .then(response => {
                setLugares(response.data); 
            })
            .catch(error => {
                console.error('Error al cargar los lugares:', error);
            });
    }, []);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setEvento({
            ...evento,
            [name]: value
        });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        if (!evento.nombre || !evento.fecha || !evento.hora || !evento.lugarId) {
            setError('Por favor, completa todos los campos obligatorios.');
            return;
        }

        if (!imagenCartel) {
            setError('Por favor, selecciona una imagen para el cartel.');
            return;
        }

        const formData = new FormData();
        formData.append('nombre', evento.nombre);
        formData.append('fecha', evento.fecha);
        formData.append('hora', evento.hora);
        formData.append('descripcion', evento.descripcion);
        formData.append('generoMusical', evento.generoMusical);
        formData.append('estado', evento.estado); 
        formData.append('lugarId', evento.lugarId); 
        formData.append('imagenCartel', imagenCartel);

        try {
            const response = await axios.post('http://localhost:8080/api/eventos', formData, {
                headers: {
                    'Content-Type': 'multipart/form-data',
                },
            });
            console.log('Evento creado:', response.data);
            setShowModal(true);
            setError(''); 
        } catch (err) {
            console.error('Error al crear el evento:', err.response?.data || err);
            setError('No se pudo crear el evento. Por favor, intenta nuevamente.');
        }
    };

    const handleModalClose = () => {
        setShowModal(false);
        window.location.href = '/'; 
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
                    <div className="form-field">
                        <label>Lugar</label>
                        <select
                            name="lugarId"
                            value={evento.lugarId}
                            onChange={handleChange}
                            required
                        >
                            <option value="">Seleccione un lugar</option>
                            {lugares.map((lugar) => (
                                <option key={lugar.lugar_id} value={lugar.lugar_id}>
                                    {lugar.nombre} ({lugar.ciudad})
                                </option>
                            ))}
                        </select>
                    </div>
                    <div className="form-field">
                        <label>Estado</label>
                        <select
                            name="estado"
                            value={evento.estado}
                            onChange={handleChange}
                            required
                        >
                            <option value="PROGRAMADO">Programado</option>
                            <option value="CANCELADO">Cancelado</option>
                            <option value="FINALIZADO">Finalizado</option>
                        </select>
                    </div>
                    <div className="form-field">
                        <label>Imagen del Cartel</label>
                        <div {...getRootProps()} className="dropzone">
                            <input {...getInputProps()} />
                            <p>Arrastra y suelta una imagen aquí, o haz clic para seleccionar</p>
                            {imagenCartel && (
                                <img
                                    src={URL.createObjectURL(imagenCartel)}
                                    alt="Imagen seleccionada"
                                    className="selected-image"
                                />
                            )}
                        </div>
                    </div>

                    <button type="submit" className="form-btn">Crear Evento</button>
                </form>
                {error && <p className="error-text">{error}</p>}
            </div>
            <Footer />
            <Modal
                showModal={showModal}
                handleClose={handleModalClose}
                message="¡Evento creado exitosamente!"
            />
        </div>
    );
};

export default CrearEvento;
