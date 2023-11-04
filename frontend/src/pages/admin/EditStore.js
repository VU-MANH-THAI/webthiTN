import React, { useState } from 'react';
import { Navigate, useParams } from 'react-router-dom';
import { toast } from 'react-toastify';
import SidebarNav from './SidebarNav';
import { addCategory, addStore, getStoreById, getSupplyById } from '../../services/fetch/ApiUtils';
import Nav from './Nav';
import { useEffect } from 'react';

const EditStore = (props) => {
    const { id } = useParams();
    const [name, setName] = useState('');
    const [phone, setPhone] = useState('');
    const [address, setAddress] = useState('');
    const [email, setEmail] = useState('');
    const { authenticated, currentUser, onLogout } = props;

    useEffect(() => {
        fetchData();
    }, []);

    const fetchData = () => {
        getStoreById(id).then(response => {
            
            setName(response.name);
            setAddress(response.address);
            setPhone(response.phone);
            setEmail(response.email);
        }).catch(
            error => {
                toast.error((error && error.message) || 'Oops! Có điều gì đó xảy ra. Vui lòng thử lại!');
            }
        )
    }

    const handleInputChange = (event) => {
        const target = event.target;
        const inputName = target.name;
        const inputValue = target.value;

        if (inputName === 'name') {
            setName(inputValue);
        } else if (inputName === 'address') {
            setAddress(inputValue);
        } else if (inputName === 'phone') {
            setPhone(inputValue);
        } else if (inputName === 'email') {
            setEmail(inputValue);
        }
    };
    

    const handleSubmit = (event) => {
        event.preventDefault();

        const storeRequest = { name, address, phone, email };

        addStore(storeRequest)
            .then((response) => {
                console.log(response.data);
                toast.success('Sửa cửa hàng thành công!!');
            })
            .catch((error) => {
                console.log(error);
                toast.error(error.message)
            });
    };

    if (!authenticated) {
        return <Navigate to={{ pathname: '/', state: { from: props.location } }} />;
    }

    console.log(name);

    return (
        <div className="wrapper">
            <nav id="sidebar" className="sidebar js-sidebar">
                <div className="sidebar-content js-simplebar">
                    <a className="sidebar-brand" href="index.html">
                        <span className="align-middle">Kioviet Cafe</span>
                    </a>
                    <SidebarNav />
                </div>
            </nav>

            <div className="main">
                <Nav onLogout={onLogout} currentUser={currentUser} />

                <main style={{ margin: '20px' }}>
                    <div className="card">
                        <div className="card-header">
                            <h5 className="card-title">Sửa cửa hàng</h5>
                            <h6 className="card-subtitle text-muted"> Sửa cửa hàng của các chuỗi cửa hàng.</h6>
                        </div>
                        <div className="card-body">
                            <form onSubmit={handleSubmit}>
                                <div className="mb-3">
                                    <label className="form-label">Tên Cửa Hàng</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="Tên danh mục"
                                        name="name"
                                        value={name}
                                        onChange={handleInputChange}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Địa Chỉ</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="Ex: Hoan Kiem Street"
                                        name="address"
                                        value={address}
                                        onChange={handleInputChange}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Số Điện Thoại</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="Ex: 0987654321"
                                        name="phone"
                                        value={phone}
                                        onChange={handleInputChange}
                                    />
                                </div>
                                <div className="mb-3">
                                    <label className="form-label">Email</label>
                                    <input
                                        type="text"
                                        className="form-control"
                                        placeholder="Ex: your-email@example.com"
                                        name="email"
                                        value={email}
                                        onChange={handleInputChange}
                                    />
                                </div>
                                <button type="submit" className="btn btn-primary">
                                    Submit
                                </button>
                            </form>
                        </div>
                    </div>
                </main>
            </div>
        </div>
    );
};

export default EditStore;