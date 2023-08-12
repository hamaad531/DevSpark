import React, { useContext } from 'react';
import { GlobalContext } from '../context/GlobalStates';

const Balance = () => {
    const { transactions } = useContext(GlobalContext);
    // console.log(transactions);
    // console.log("done");
    const amounts = transactions.map(transaction => transaction.amount);
    // console.log("done");
    const total = amounts.reduce((acc, item) => (acc += item), 0).toFixed(2);
    return (
        <>
            <h4>Your Balance</h4>
            <h1 >{total}</h1>
        </>
    )
}

export default Balance