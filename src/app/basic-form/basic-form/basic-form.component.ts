import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-basic-form',
  templateUrl: './basic-form.component.html',
  styleUrls: ['./basic-form.component.scss']
})
export class BasicFormComponent implements OnInit {
  form: FormGroup;
  programmingLanguages = ['TS', 'JS', 'C#'];

  constructor() { }

  ngOnInit() {
    this.form = new FormGroup({
      firstName: new FormControl("Anastasios", [Validators.required, Validators.minLength(3)]),
      lastName: new FormControl("Louvoulinas", Validators.required),
      isExperienced: new FormControl("1", Validators.required),
      angular: new FormControl("1", Validators.required),
      favouriteLanguage: new FormControl(null, Validators.required),
      jsversion: new FormControl(null, Validators.required),
    });

    this.form.get('favouriteLanguage').valueChanges.subscribe(value => {

      const jsVersionFormControl = this.form.get('jsversion');

      if (value === 'JS') {
        jsVersionFormControl.setValidators(Validators.required);
      } else {
        jsVersionFormControl.clearValidators();
      }
      jsVersionFormControl.updateValueAndValidity();
    });

    this.form.get('favouriteLanguage').valueChanges.subscribe(value => {

      const jsVersionFormControl = this.form.get('jsversion');

      if (value !== 'JS') {
        jsVersionFormControl.disable();
      } else {
        jsVersionFormControl.enable();
      }
      jsVersionFormControl.updateValueAndValidity();
    });
  }

}
