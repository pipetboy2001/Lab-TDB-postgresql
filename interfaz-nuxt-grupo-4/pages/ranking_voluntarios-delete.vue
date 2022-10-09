<template>
  <div class="container" style="width:700px;">
    <h1>¿Eliminar Ranking-Voluntario?</h1>
    <table class="table table-hover table-striped table-dark table-bordered table-secondary">
      <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">EMERGENCIA</th>
        <th scope="col">TAREA</th>
        <th scope="col">CANT. VOL. REQ.</th>
        <th scope="col">ID VOL</th>
        <th scope="col">PUNTAJE</th>
      </tr>
      </thead>
      <tbody>
      <td>{{ form.id }}</td>
      <td>{{ form.id_emergencia }}</td>
      <td>{{ form.tarea }}</td>
      <td>{{ form.cant_vol_req }}</td>
      <td>{{ form.id_vol }}</td>
      <td>{{ form.puntaje }}</td>
      </tbody>
    </table>
    <button type="submit" class="btn btn-danger" v-on:click="eliminar()">ELIMINAR</button>
    <button type="submit" class="btn btn-dark" v-on:click="cancelar()">CANCELAR</button>
  </div>
</template>



<script>

import axios from 'axios'

export default {
  name: 'BORRAR',
  data: function () {
    return {
      RANKING_VOLUNTARIOS_ID: '',
      form: {
        id: null,
        id_emergencia: '',
        tarea: '',
        cant_vol_req: '',
        id_vol: '',
        puntaje: ''
      }
    }
  },
  methods: {
    cancelar () {
      this.$router.push('/ranking_voluntarios')
    },
    eliminar () {
      const enviar = {
        id: this.RANKING_VOLUNTARIOS_ID,
        token: this.form.token
      }
      axios.delete('http://localhost:3000/ranking_voluntarios/' + this.RANKING_VOLUNTARIOS_ID, { headers: enviar })
        .then(datos => {
          console.log(datos)
          this.makeToast('BORRADO', 'Ranking-Voluntario eliminar', 'danger')
          this.$router.push('/ranking_voluntarios')
        }).catch(error => {
        console.log(error)
        this.makeToast('Error', 'No se pudo agregar el Ranking-voluntario', 'error')
      })
    },
    makeToast (titulo, texto, tipo) {
      this.toastCount++
      this.$bvToast.toast(texto, {
        title: titulo,
        variant: tipo,
        autoHideDelay: 5000,
        appendToast: true
      })
    }
  },

  mounted: function () {
    this.RANKING_VOLUNTARIOS_ID = this.$route.query.id
    const endpointRankingVoluntarios = 'http://localhost:3000/ranking_voluntariados/' + this.RANKING_VOLUNTARIOS_ID
    axios.get(endpointRankingVoluntarios).then(
      response => {
        this.form.id = this.RANKING_VOLUNTARIOS_ID
        this.form.id_emergencia = response.data.id_emergencia
        this.form.tarea = response.data.tarea
        this.form.cant_vol_req = response.data.cant_vol_req
        this.form.id_vol = response.data.id_vol
        this.form.puntaje = response.data.puntaje
        this.form.toke = localStorage.getItem('token')
      }
    )
  }
}
</script>
<style>

</style>
