<template>
  <div class="hello">
    <h1>{{ msg }}</h1>
    <vue-form-generator :schema="schema" :model="model" :options="formOptions"></vue-form-generator>
    <button v-on:click="submit">Enviar</button>
  </div>
</template>

<script>
import VueFormGenerator from "vue-form-generator/dist/vfg-core.js";
import "vue-form-generator/dist/vfg-core.css";

export default {
  name: 'SeleniumForm',
  props: {
    msg: String
  },
  components: {
      "vue-form-generator": VueFormGenerator.component
  },
  data() {
    return {
        model: {
            name: "Selenium test",
            email: "",
            skills: ["Selenium"]
        },
        schema: {
            fields: [{
                type: "input",
                inputType: "text",
                label: "Nombre",
                model: "name",
                readonly: false,
                featured: true,
                required: true,
                disabled: false,
                placeholder: "Nombre",
                validator: VueFormGenerator.validators.string
            }, {
                type: "input",
                inputType: "email",
                label: "E-mail",
                model: "email",
                placeholder: "E-mail",
                validator: VueFormGenerator.validators.email
            }, {
                type: "checklist",
                label: "Skills",
                model: "skills",
                multi: true,
                required: true,
                multiSelect: true,
                values: ["Selenium", "Tests", "Cucumber"]
            }]
      },
      formOptions: {
          validateAfterLoad: true,
          validateAfterChanged: true
      }
    };
  },
  methods: {
    submit: function() {
      this.$router.push({ name: "SeleniumResults", query: { name: this.model.name, email: this.model.email, skills: this.model.skills } });
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
</style>
