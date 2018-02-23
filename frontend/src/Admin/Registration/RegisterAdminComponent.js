import React from 'react';

const RegisterAdminComponent = (props) => {
  return(
    <form className="form-horizontal">

            <div className="form-group">
                <label className="col-sm-2 control-label">Vardas</label>
                <div className="col-sm-3">
                    <input type="text" className="form-control" id="name" placeholder="Vardas" value={props.name}
                           onChange={props.onChange}/>
                </div>
            </div>

            <div className="form-group">
                <label className="col-sm-2 control-label">Pavardė</label>
                <div className="col-sm-3">
                    <input type="text" className="form-control" id="surname" placeholder="Pavardė" value={props.surname}
                           onChange={props.onChange}/>
                </div>
            </div>

            <div className="form-group">
                <label className="col-sm-2 control-label">Slapyvardis</label>
                <div className="col-sm-3">
                    <input type="text" className="form-control" id="username" placeholder="Slapyvardis" value={props.username}
                           onChange={props.onChange}/>
                </div>
            </div>

            <div className="form-group">
                <label className="col-sm-2 control-label">Slaptažodis</label>
                <div className="col-sm-3">
                    <input type="text" className="form-control" id="password" placeholder="Slaptažodis" value={props.password}
                           onChange={props.onChange}/>
                </div>
            </div>

            <div className="form-group">
                <div className="col-sm-offset-2 col-sm-3">
                    <button type="submit" className="btn btn-success" onClick={props.onClick}>Išsaugoti</button>
                    <button type="submit" className="btn btn-default" onClick={props.history.goBack}>Atšaukti</button>
                </div>
            </div>
        </form>
  );
};

export default RegisterAdminComponent;
