import { Blockchain } from './blockchain'

const blockNumber = +process.argv[3] || 10
const blockchain = new Blockchain(Number(process.argv[2] || 4))
let chain = blockchain.chain

for (let i = 0; i < blockNumber; i++) {
  const bloco = blockchain.criarBloco(`Block ${i}`)
  const mineInfo = blockchain.minerarBloco(bloco)
  chain = blockchain.enviarBloco(mineInfo.blocoMinerado)
}

console.log(' -- blockchain -- ')
console.log(chain)
