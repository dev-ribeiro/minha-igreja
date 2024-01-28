import { Container } from "@components/Container";
import { useCongration } from "@hooks/useCongragation";
import Box from '@mui/material/Box'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Button from '@mui/material/Button';
import AddIcon from '@mui/icons-material/Add';
import Modal from '@mui/material/Modal';
import Typography from '@mui/material/Typography';
import TextField from '@mui/material/TextField';

export function Congregation() {
  const {
    registerCongregationModalVisibility,
    updateRegisterCongregationModalVisibility
  } = useCongration();

  return (
    <>
      <Container>
        <Typography variant="h4" component="h1">Congregações</Typography>
        <div className="flex justify-end">
          <Button
            variant="text"
            startIcon={<AddIcon />}
            onClick={() => updateRegisterCongregationModalVisibility(true)}
          >
            Adicionar
          </Button>
        </div>
        <Box>
          <TableContainer>
            <Table>
              <TableHead>
                <TableRow>
                  <TableCell>Nome</TableCell>
                  <TableCell>Contato</TableCell>
                  <TableCell>Endereço</TableCell>
                </TableRow>
              </TableHead>
              <TableBody>
                <TableRow>
                  <TableCell>Igreja Batista Vale Santa Cecília</TableCell>
                  <TableCell>(85) 9 8646-5315</TableCell>
                  <TableCell>Rua Martins de Carvalho, 1800</TableCell>
                </TableRow>
              </TableBody>
            </Table>
          </TableContainer>
        </Box>
      </Container>

      <Modal
        open={registerCongregationModalVisibility}
        onClose={() => updateRegisterCongregationModalVisibility(false)}
        className="flex items-center justify-center"
      >
        <div className="min-w-[50vw] flex flex-col p-3 bg-gray-100 rounded gap-3">
          <Typography variant="subtitle1">
            Cadastro de congregação
          </Typography>
          <form className="flex flex-col gap-4">
            <div className="flex flex-col">
              <label htmlFor="name">Nome:</label>
              <TextField name="name" />
            </div>
            <div className="flex flex-col">
              <label htmlFor="phone">Contato:</label>
              <TextField name="phone" />
            </div>
            <div className="flex flex-col">
              <label htmlFor="address">Endereço:</label>
              <TextField name="address" />
            </div>
            <Button variant="contained">
              CADASTRAR
            </Button>
          </form>
        </div>
      </Modal>
    </>
  );
}
