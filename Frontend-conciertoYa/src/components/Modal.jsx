import React from 'react';
import { Button, Modal as BootstrapModal } from 'react-bootstrap';

function Modal({ showModal, handleClose }) {
return (
<BootstrapModal show={showModal} onHide={handleClose}>
    <BootstrapModal.Header closeButton>
    <BootstrapModal.Title>Creación de Artista</BootstrapModal.Title>
    </BootstrapModal.Header>

    <BootstrapModal.Body>
    <p>Artista creado exitosamente!</p>
    </BootstrapModal.Body>

    <BootstrapModal.Footer>
    <Button variant="secondary" onClick={handleClose}>
        OK
    </Button>
    </BootstrapModal.Footer>
</BootstrapModal>
);
}

export default Modal;
