import React from 'react';
import {PharPrescriptionComponent} from "./PharPrescriptionComponent";

const tableStyle = {
    margin : {marginTop : 20},
};

export var PharPrescriptionListComponent = (props) => {

    const prescriptions = props.prescriptions.map((prescription, index) => {
        return (
            <PharPrescriptionComponent
                key = {index}
                id = {prescription.id}
                personalId = {prescription.personalId}
                date = {prescription.date}
                activeMat = {prescription.activeMat}
                activeMatQuantity = {prescription.activeMatQuantity}
                unit = {prescription.unit}
                desc = {prescription.desc}
                doctorUsername = {prescription.doctorUsername}
                validUntil = {prescription.validUntil}
                history = {props.history}
                remove = {props.remove}
            />
        );
    });

    return (
        <div>
            <div className="panel panel-default" style={tableStyle.margin}>
                <table className="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Asmens kodas</th>
                        <th>Data</th>
                        <th>Aktivi medžiaga</th>
                        <th>Kiekis</th>
                        <th>Vnt.</th>
                        <th>Aprašymas</th>
                        <th>Daktaras</th>
                        <th>Galioja iki</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    {prescriptions}
                    </tbody>
                </table>
            </div>
        </div>
    );
};
