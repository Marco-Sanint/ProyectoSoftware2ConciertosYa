import React, { useState } from 'react';
import { FormControl, InputLabel, Select, MenuItem, TextField, Button } from '@mui/material';
import './RedesSociales.css'; // Asegúrate de que tus estilos estén bien configurados

const RedesSociales = () => {
const [redesSeleccionadas, setRedesSeleccionadas] = useState([]);
const [redesSociales, setRedesSociales] = useState({
facebook: '',
twitter: '',
instagram: '',
youtube: '',
});
const [redSeleccionada, setRedSeleccionada] = useState('');

const listaRedes = [
{ id: 'facebook', nombre: 'Facebook' },
{ id: 'twitter', nombre: 'Twitter' },
{ id: 'instagram', nombre: 'Instagram' },
{ id: 'youtube', nombre: 'YouTube' },
];

// Función para manejar la selección de una red social
const handleSelectRed = (e) => {
const { value } = e.target;
setRedSeleccionada(value);

// Si el usuario selecciona una red social, la agregamos a la lista de redes seleccionadas
if (value && !redesSeleccionadas.includes(value)) {
    setRedesSeleccionadas([...redesSeleccionadas, value]);
}
};

// Función para manejar los cambios en las URLs
const handleChangeRed = (e) => {
const { name, value } = e.target;
setRedesSociales({
    ...redesSociales,
    [name]: value,
});
};

// Función para quitar una red social
const handleRemoveRed = (red) => {
setRedesSeleccionadas(redesSeleccionadas.filter((r) => r !== red));
setRedesSociales({
    ...redesSociales,
    [red]: '', // Limpiamos el campo de URL cuando se elimina la red
});
};

return (
<div className="redes-container">
    <h2>Redes Sociales</h2>

    {/* Menú desplegable para seleccionar redes sociales */}
    <FormControl fullWidth>
    <InputLabel id="red-social-label">Selecciona una red social</InputLabel>
    <Select
        labelId="red-social-label"
        id="red-social-select"
        value={redSeleccionada}
        label="Selecciona una red social"
        onChange={handleSelectRed}
    >
        <MenuItem value="">Selecciona una red social</MenuItem>
        {listaRedes.map((red) => (
        <MenuItem key={red.id} value={red.id}>
            {red.nombre}
        </MenuItem>
        ))}
    </Select>
    </FormControl>

    {/* Mostrar campos para las URLs de las redes seleccionadas */}
    <div>
    {redesSeleccionadas.map((red) => (
        <div key={red} className="red-social-container">
        <TextField
        label={`URL de ${red.charAt(0).toUpperCase() + red.slice(1)}`}
        variant="outlined"
        fullWidth
        name={red}
        value={redesSociales[red]}
        onChange={handleChangeRed}
        placeholder={`Ingresa la URL de ${red}`}
        style={{ marginBottom: '10px' }}
        />
        <Button
            variant="contained"
            color="error"
            onClick={() => handleRemoveRed(red)}
            style={{ marginTop: '10px', marginBottom: '15px' }}
        >
            Quitar
        </Button>
        </div>
    ))}
    </div>
</div>
);
};

export default RedesSociales;
