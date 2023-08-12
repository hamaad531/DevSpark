import Header from './components/Header';
import Balance from './components/Balance';
import IncomeExpenses from './components/IncomeExpenses';
import TransactionHistory from './components/TransactionHistory';
import AddTransaction from './components/AddTransaction';
import './App.css';
import { GlobalProvider } from './context/GlobalStates';

function App() {
  return (
    <GlobalProvider >
      <Header />
      <div className='container'>
        <Balance />
        <IncomeExpenses />
        <TransactionHistory />
        <AddTransaction />
      </div>
    </GlobalProvider>
  );
}

export default App;
