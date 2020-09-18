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
    // this.form = new FormGroup({
    //   firstName: new FormControl("Anastasios", [Validators.required, Validators.minLength(3)]),
    //   lastName: new FormControl("Louvoulinas", Validators.required),
    //   isExperienced: new FormControl("1", Validators.required),
    //   angular: new FormControl("1", Validators.required),
    //   favouriteLanguage: new FormControl(null, Validators.required),
    //   jsversion: new FormControl(null, Validators.required),
    // });

    this.form = new FormGroup({
      firstName: new FormControl(null, [Validators.required, Validators.minLength(3)]),
      lastName: new FormControl(null, Validators.required),
      isExperienced: new FormControl(),
      angular: new FormControl(null, Validators.required),
      favouriteLanguage: new FormControl(null, Validators.required),
      jsversion: new FormControl(null, Validators.required)
    })
    this.form.get('favouriteLanguage').valueChanges.subscribe(value => {

      const jsVersionFormControl = this.form.get('jsversion');

      if (value === 'JS') {
        jsVersionFormControl.setValidators(Validators.required);
        jsVersionFormControl.enable();
      } else {
        jsVersionFormControl.clearValidators();
        jsVersionFormControl.disable();
      }
      jsVersionFormControl.updateValueAndValidity();
    });

  }

}
