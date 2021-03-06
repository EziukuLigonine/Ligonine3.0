import React, { Component } from 'react';
import {Route, Switch } from 'react-router-dom';
import {PrescriptionListContainer} from "./PrescriptionList/PrescriptionListContainer";
import {RecordAdministrationContainer} from "./RecordAdministration/RecordAdministrationContainer";
import {PrescriptionAdministrationContainer} from "./PrescriptionAdministration/PrescriptionAdministrationContainer";
import {RecordListContainer} from "./RecordList/RecordListContainer";
import PrescriptionDetailsContainer from "./PrescriptionDetails/PrescriptionDetailsContainer";
import {RecordDetailsContainer} from "./RecordDetails/RecordDetailsContainer";
import DocPatientList from "./PatientList/PatientList";
import {DocPatientPrescriptions} from "./PatientPrescriptions/DocPatientPrescriptions";
import {DocPatientRecords} from "./PatientRecords/DocPatientRecords";
import DoctorPatientList from "./PatientList/DoctorPatientList";
import PatientDetailsContainer from './PatientDetails/PatientDetailsContainer';



class AdminRouter extends Component {
    render(){
        return(
            <div>
                <Switch>
                    <Route exact path="/doctor/prescriptions" component={PrescriptionListContainer} />
                    <Route exact path="/doctor/patient/:id/prescription" component={PrescriptionAdministrationContainer} />

                    <Route exact path="/doctor/patient/:id/record" component={RecordAdministrationContainer} />
                    <Route exact path="/doctor/records" component={RecordListContainer} />

                    <Route exact path="/doctor/prescription/:id" component={PrescriptionDetailsContainer} />
                    <Route exact path="/doctor/records/:id" component={RecordDetailsContainer} />

                    <Route exact path="/doctor/patients" component={DocPatientList} />

                    <Route exact path="/doctor/patient/records/:id" component={DocPatientRecords} />
                    <Route exact path="/doctor/patient/prescriptions/:id" component={DocPatientPrescriptions} />
                    <Route exact path="/doctor/patient/:id" component={PatientDetailsContainer} />
                    <Route path="/doctor/myPatients" component={DoctorPatientList} />
                </Switch>
            </div>
        );
    }
}

export default AdminRouter;
