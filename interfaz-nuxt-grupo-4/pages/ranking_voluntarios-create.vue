<template>
  <div class="container" style="width:700px;">
    <h1>EDITAR DATOS</h1>
    <form>



      <div class="form-group">
        <label for="nombre">Id Emergencia</label>
        <input type="text" class="form-control" minlength="3" maxlength="100" id="id_emergencia" v-model="form.id_emergencia" required>
        <small id="id_emergencia" class="form-text text-muted">Ingrese el id de la Emergencia a cambiar.</small>
      </div>


      <div class="form-group">
        <label for="descripcion">Tarea</label>
        <input type="text" class="form-control" minlength="5" maxlength="400" id="tarea" v-model="form.tarea" required>
        <small id="tarea" class="form-text text-muted">Ingrese la tarea a cambiar.</small>
      </div>

      <div class="form-group">
        <label for="descripcion">Cant Volumen Requerida</label>
        <input type="text" class="form-control" minlength="5" maxlength="400" id="cant_vol_req" v-model="form.cant_vol_req" required>
        <small id="cant_vol_req" class="form-text text-muted">Ingrese nuevo volumen a cambiar.</small>
      </div>


      <div class="form-group">
        <label for="descripcion">Id Volumen</label>
        <input type="text" class="form-control" minlength="5" maxlength="400" id="id_vol" v-model="form.id_vol" required>
        <small id="id_vol" class="form-text text-muted">Ingrese nuevo id de volumen.</small>
      </div>


      <div class="form-group">
        <label for="descripcion">Puntaje</label>
        <input type="text" class="form-control" minlength="5" maxlength="400" id="puntaje" v-model="form.puntaje" required>
        <small id="puntaje" class="form-text text-muted">Ingrese nuevo puntaje.</small>
      </div>



      <button type="submit" class="btn btn-primary" v-on:click="crear()">CREAR</button>
      <button type="submit" class="btn btn-dark" v-on:click="cancelar()">CANCELAR</button>
    </form>
  </div>

</template>

<script>

import axios from 'axios'

export default {
  name: 'CREAR',
  data: function () {
    return {
      form: {
        id_emergencia: '',
        tarea: '',
        cant_vol_req: '',
        id_vol: '',
        puntaje: '',
        token: ''
      }
    }
  },
  methods: {
    crear () {
      this.form.token = localStorage.getItem('token')
      axios.post('http://localhost:3000/ranking_voluntariados', this.form)
        .then(data => {
          console.log(data)
          this.makeToast('Listo', 'Ranking-Voluntario agregada', 'success')
        }).catch(error => {
        console.log(error)
        this.makeToast('Error', 'No se pudo agregar el Ranking-Voluntario', 'error')
      })
      this.$router.push('../ranking_voluntariados')
    },
    cancelar () {
      this.$router.push('/ranking_voluntariados')
    },
    makeToast (titulo, texto, tipo) {
      this.toastCount++
      this.$bvToast.toast(texto, {
        title: titulo,
        variant: tipo,
        autoHideDelay: 10000,
        appendToast: true
      })
    }

  }
}
</script>
<style>

</style>
