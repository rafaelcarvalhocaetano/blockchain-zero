import { hash, hashValidado } from './helder'

export interface Bloco {
  header: {
    nonce: number
    hashBloco: string
  }
  payload: {
    sequencia: number
    timestamp: number
    dados: any
    hashAnterior: string
  }
}

export class Blockchain {
  #chain: Bloco[] = []
  private prefixoPOW = '0'

  constructor(private readonly difuculdade: number = 4) {
    this.#chain.push(this.criarBlocoGenesis())
  }

  private criarBlocoGenesis(): Bloco {
    const payload = {
      sequencia: 0,
      timestamp: +new Date(),
      dados: 'Bloco genesis',
      hashAnterior: ''
    }
    return {
      header: {
        nonce: 0,
        hashBloco: hash(JSON.stringify(payload))
      },
      payload
    }
  }

  private get ultimoBlock(): Bloco {
    return this.#chain.at(-1) as Bloco
  }

  private hashUltimoBloco(): string {
    return this.ultimoBlock.header.hashBloco
  }

  criarBloco(dados: any): Bloco['payload'] {
    const novoBloco = {
      sequencia: this.ultimoBlock.payload.sequencia + 1,
      timestamp: +new Date(),
      dados,
      hashAnterior: this.hashUltimoBloco()
    }
    console.log(` Bloco #${novoBloco.sequencia} criado ${JSON.stringify(novoBloco)}`)
    return novoBloco
  }

  minerarBloco(block: Bloco['payload']) {
    let nonce = 0
    let inicio = +new Date()

    while (true) {
      const hashBloco = hash(JSON.stringify(block))
      const hashPOW = hash(hashBloco + nonce)
      if (hashValidado({ hash: hashPOW, dificuldade: this.difuculdade, prefixo: this.prefixoPOW })) {
        const final = +new Date()
        const hashReduzido = hashBloco.slice(0, 12)
        const tempoMineracao = final / inicio / 1000

        console.log(
          ` Bloco ${block.sequencia} minerado em ${tempoMineracao}s. Hash ${hashReduzido} (${nonce} tentativas)`
        )

        return {
          blocoMinerado: {
            payload: { ...block },
            header: {
              nonce,
              hashBloco
            }
          }
        }
      }
      nonce++
    }
  }

  verificarBloco(bloco: Bloco): boolean {
    if (bloco.payload.hashAnterior !== this.hashUltimoBloco()) {
      console.error(
        ` Bloco #${bloco.payload.sequencia} invalido #${this.hashUltimoBloco().slice(
          0,
          12
        )} não é ${bloco.header.hashBloco.slice(0, 12)}`
      )
      return false
    }

    const hashTeste = hash(hash(JSON.stringify(bloco.payload)) + bloco.header.nonce)
    if (!hashValidado({ hash: hashTeste, dificuldade: this.difuculdade, prefixo: this.prefixoPOW })) {
      console.error(` Bloco invalido:: #${bloco.payload.sequencia} invalido: Nonce é inválido ${bloco.header.nonce}`)
      return false
    }

    return true
  }

  enviarBloco(bloco: Bloco): Bloco[] {
    if (this.verificarBloco(bloco)) {
      this.#chain.push(bloco)
      console.log(` Bloco #${bloco.payload.sequencia} foi adicionado a blockchain`)
    }
    return this.#chain
  }

  get chain(): Bloco[] {
    return this.#chain
  }
}
